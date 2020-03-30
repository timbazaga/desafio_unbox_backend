package com.unboxculture.desafio.arquitetura.exception;

import org.springframework.context.MessageSource;

import java.util.Locale;

public enum MensagemError {
    NOT_FOUND(404, "erro.http.notfound"),
    NAO_AUTENTICADO(401, "usuario.nao.autenticado"),
    ERRO_DESCONHECIDO(500, "erro.http.desconhecido"),
    SEM_PERMISSAO(403, "erro.http.forbidden"),
    NO_CONTENT(204, "erro.http.nocontent"),
    BAD_REQUEST(400, "erro.http.badrequest"),
    HEADERS_INVALIDOS(400, "erro.http.headers.invalidos"),
    ERRO_NEGOCIO(409, "erro.negocio");

    private Integer codigo;
    private String key;

    MensagemError(Integer codigo, String key) {
        this.codigo = codigo;
        this.key = key;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getKey() {
        return key;
    }

    public String getMensagem(MessageSource bundle) {
        return getMensagem(bundle, null);
    }

    public String getMensagem(MessageSource bundle, String... params) {
        return bundle.getMessage(getKey(), params, Locale.getDefault());
    }

    @Override
    public String toString() {
        return key;
    }
}
