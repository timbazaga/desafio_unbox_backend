package com.unboxculture.desafio.arquitetura.exception;

import org.springframework.context.MessageSource;

public class NegocioException extends RuntimeException {

    public NegocioException(MessageSource bundle) {
        super(MensagemError.ERRO_NEGOCIO.getMensagem(bundle));
    }

    public NegocioException(MessageSource bundle, MensagemError error) {
        super(error.getMensagem(bundle));
    }

    public NegocioException(MessageSource bundle, MensagemError error, String... params) {
        super(error.getMensagem(bundle, params));
    }

    public NegocioException(String mensagem) {
        super(mensagem);
    }
}

