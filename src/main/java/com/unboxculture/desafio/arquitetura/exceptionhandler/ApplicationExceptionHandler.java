package com.unboxculture.desafio.arquitetura.exceptionhandler;

import com.unboxculture.desafio.arquitetura.exception.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ErroLog> erros = criarListaDeErros(ex.getBindingResult(), HttpStatus.BAD_REQUEST);
        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    private List<ErroLog> criarListaDeErros(BindingResult bindingResult, HttpStatus status) {
        List<ErroLog> erros = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String mensagemUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()).replaceAll("\\{field\\}", fieldError.getField());
            String mensagemDesenvolvedor = fieldError.toString();
            erros.add(new ErroLog(String.format("%d - %s", status.value(), status.getReasonPhrase()), mensagemUsuario, mensagemDesenvolvedor));
        }
        return erros;
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity handleNegocioException(NegocioException ex, WebRequest request) {
        log.warn(ex);
        return createResponseEntity(ex, request, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException ex, WebRequest request) {
        log.warn(ex);
        return createResponseEntity(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequestException(BadRequestException ex, WebRequest request) {
        log.warn(ex);
        return createResponseEntity(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity handleNoContentException(NoContentException ex, WebRequest request) {
        log.warn(ex);
        return createResponseEntity(ex, request, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity handleUnauthorizedException(RuntimeException ex, WebRequest request) {
        log.warn(ex);
        return createResponseEntity(ex, request, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity handleInternalServerErrorException(RuntimeException ex, WebRequest request) {
        log.error(ex);
        log.trace(ex);
        return saveLogResponseEntity(ex, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGeneralException(Exception ex, WebRequest request) {
        log.error(ex);
        log.trace(ex);
        return saveLogResponseEntity(ex, request);
    }

    private ResponseEntity saveLogResponseEntity(Exception ex, WebRequest request) {
        HttpServletRequest req = ((ServletRequestAttributes) request).getRequest();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String statusDescricao = String.format("%d - %s", status.value(), status.getReasonPhrase());
        ErroLog error = ErroLog.builder()
                .metodoHttp(req.getMethod())
                .endpoint(req.getRequestURI().replaceAll("//", "/"))
                .statusCode(statusDescricao)
                .message(MensagemError.ERRO_DESCONHECIDO.getMensagem(messageSource))
                .detalhes(StringUtils.join(ExceptionUtils.getRootCauseStackTrace(ex), "\n"))
                .dataHora(LocalDateTime.now())
                .build();
        error.setDetalhes(ExceptionUtils.getRootCauseMessage(ex));
        return createResponseEntity(ex, error, request, status);
    }

    private ResponseEntity createResponseEntity(Exception ex, WebRequest request, HttpStatus status) {
        HttpServletRequest req = ((ServletRequestAttributes) request).getRequest();
        ErroLog error = ErroLog.builder()
                .metodoHttp(req.getMethod())
                .endpoint(req.getRequestURI().replaceAll("//", "/"))
                .statusCode(status.value() + " - " + status.getReasonPhrase())
                .message(ex.getMessage())
                .detalhes(ExceptionUtils.getRootCauseMessage(ex))
                .dataHora(LocalDateTime.now())
                .build();
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    private ResponseEntity createResponseEntity(Exception ex, ErroLog error, WebRequest request, HttpStatus status) {
        return handleExceptionInternal(
                ex, error, new HttpHeaders(), status, request);
    }
}
