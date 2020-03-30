package com.unboxculture.desafio.arquitetura.exception;

import org.springframework.context.MessageSource;

public class BadRequestException extends RuntimeException {

    public BadRequestException(MessageSource bundle) {
        super(MensagemError.BAD_REQUEST.getMensagem(bundle));
    }

    public BadRequestException(MessageSource bundle, MensagemError error) {
        super(error.getMensagem(bundle));
    }

    public BadRequestException(MessageSource bundle, MensagemError error, String... params) {
        super(error.getMensagem(bundle, params));
    }

    public BadRequestException(String mensagem) {
        super(mensagem);
    }
}

