package com.unboxculture.desafio.arquitetura.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messager {

    @Autowired
    private MessageSource source;

    public String get(MessageSourceResolvable resolvable, Locale locale) {
        return source.getMessage(resolvable, locale);
    }
    public String get(MessageSourceResolvable resolvable) {
        return source.getMessage(resolvable, Locale.getDefault());
    }

    public String get(String mensagem, Locale locale, Object... params) {
        return source.getMessage(mensagem, params, locale);
    }

    public String get(String mensagem, Object... params) {
        return get(mensagem, null, params);
    }

    public String get(String mensagem) {
        return get(mensagem, null);
    }
}
