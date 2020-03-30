package com.unboxculture.desafio.arquitetura.exception;

import org.springframework.context.MessageSource;

public class NoContentException extends RuntimeException {

    public NoContentException(MessageSource bundle) {
        super(MensagemError.NO_CONTENT.getMensagem(bundle));
    }

    public NoContentException(MessageSource bundle, MensagemError error) {
        super(error.getMensagem(bundle));
    }

    public NoContentException(MessageSource bundle, MensagemError error, String... params) {
        super(error.getMensagem(bundle, params));
    }
}

