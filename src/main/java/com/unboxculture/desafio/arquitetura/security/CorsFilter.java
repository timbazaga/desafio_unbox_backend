package com.unboxculture.desafio.arquitetura.security;

import com.unboxculture.desafio.arquitetura.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Profile("prod")
public class CorsFilter implements Filter {

    @Autowired
    private ApplicationProperties properties;

    private List<String> origensPermitidas;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String origemRequisicao = request.getHeader("Origin");

        if(Objects.isNull(origensPermitidas)) {
            origensPermitidas = Arrays.asList(properties.getOrigemPermitida().split(";"));
        }

        if (origensPermitidas.stream().anyMatch(permitida -> permitida.startsWith(origemRequisicao))) {
            response.setHeader("Access-Control-Allow-Origin", origemRequisicao);
        } else {
            response.setHeader("Access-Control-Allow-Origin", null);
        }

        // Headers que devem ser enviados SEMPRE
        response.setHeader("Access-Control-Allow-Credentials", "true"); // Precisa desse Header para o cookie do RefreshToken ser enviado.

        if ("OPTIONS".equals(request.getMethod())
                && origensPermitidas.stream().anyMatch(permitida -> permitida.startsWith(origemRequisicao))) { // Verifica se a Origem desse OPTIONS é permitida
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
            response.setHeader("Access-Control-Max-Age", "3600");

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void destroy() {}
}
