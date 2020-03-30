package com.unboxculture.desafio.arquitetura.exception;

import org.springframework.context.MessageSource;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(MessageSource bundle) {
        super(MensagemError.ERRO_DESCONHECIDO.getMensagem(bundle));
    }

    public InternalServerErrorException(MessageSource bundle, MensagemError error) {
        super(error.getMensagem(bundle));
    }

    public InternalServerErrorException(MessageSource bundle, MensagemError error, String... params) {
        super(error.getMensagem(bundle, params));
    }

    public InternalServerErrorException(String mensagem) {
        super(mensagem);
    }
}
