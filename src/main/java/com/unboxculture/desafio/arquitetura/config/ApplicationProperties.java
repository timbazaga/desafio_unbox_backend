package com.unboxculture.desafio.arquitetura.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
@Getter
@Setter
public class ApplicationProperties {

    private String swaggerHost;
    private ServicosProperties servicos = new ServicosProperties();
    private String origemPermitida;
    private Integer tokenExpiration;

    @Getter
    @Setter
    public class ServicosProperties {
        private String theMovieDbUrl;
    }
}
