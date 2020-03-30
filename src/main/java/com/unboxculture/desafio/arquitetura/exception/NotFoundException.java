package com.unboxculture.desafio.arquitetura.exception;

import org.springframework.context.MessageSource;


public class NotFoundException extends RuntimeException {

    public NotFoundException(MessageSource bundle) {
        super(MensagemError.NOT_FOUND.getMensagem(bundle));
    }

    public NotFoundException(MessageSource bundle, MensagemError error) {
        super(error.getMensagem(bundle));
    }

    public NotFoundException(MessageSource bundle, MensagemError error, String... params) {
        super(error.getMensagem(bundle, params));
    }

    public NotFoundException(String message) {
        super(message);
    }
}
