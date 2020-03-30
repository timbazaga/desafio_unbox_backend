package com.unboxculture.desafio.arquitetura.adapter;

import com.unboxculture.desafio.arquitetura.exception.InternalServerErrorException;
import com.unboxculture.desafio.arquitetura.message.Messager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class BaseAdapter {

    @Autowired
    private Messager messager;

    ResponseEntity get(String url, HttpHeaders headers, Class responseType) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(null, headers);
        RestTemplate rest = new RestTemplate();
        HttpMethod metodo = HttpMethod.GET;
        try {
            return rest.exchange(url, metodo, request, responseType);
        } catch (Exception e) {
            throw new InternalServerErrorException(
                    messager.get("erro.adapter.servico", url, metodo));
        }
    }

    boolean isResponseOk(ResponseEntity responseEntity) {
        return responseEntity.getStatusCodeValue() > 199 && responseEntity.getStatusCodeValue() < 299;
    }
}
