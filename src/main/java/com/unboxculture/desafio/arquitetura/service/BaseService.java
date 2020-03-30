package com.unboxculture.desafio.arquitetura.service;

import com.unboxculture.desafio.arquitetura.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BaseService<T extends BaseEntity<T, ID>,ID> {

    @Autowired
    private MessageSource messageSource;

    protected MessageSource getMessageSource() {
        return messageSource;
    }

    protected String getMensagem(String key) {
        return messageSource.getMessage(key, null, Locale.getDefault());
    }

    protected String getMensagem(String key, Object... params) {
        return messageSource.getMessage(key, params, Locale.getDefault());
    }

    protected String getMensagem(String key, Locale locale, Object... params) {
        return messageSource.getMessage(key, params, locale);
    }
}
