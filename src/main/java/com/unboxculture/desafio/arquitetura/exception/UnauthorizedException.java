package com.unboxculture.desafio.arquitetura.exception;

import org.springframework.context.MessageSource;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(MessageSource bundle) {
        super(MensagemError.SEM_PERMISSAO.getMensagem(bundle));
    }

    public UnauthorizedException(MessageSource bundle, MensagemError error) {
        super(error.getMensagem(bundle));
    }

    public UnauthorizedException(MessageSource bundle, MensagemError error, String... params) {
        super(error.getMensagem(bundle, params));
    }

    public UnauthorizedException(String mensagem) {
        super(mensagem);
    }
}
