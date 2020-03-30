package com.unboxculture.desafio.arquitetura.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unboxculture.desafio.arquitetura.util.serializers.LocalDateTimeSerializer;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErroLog implements Serializable {

    private Integer id;
    private Integer matricula;
    private String papel;
    private String metodoHttp;
    private String endpoint;
    private String statusCode;
    private String message;
    private String detalhes;
    private LocalDateTime dataHora;

    public ErroLog(String statusCode, String message, String detalhes) {
        this.statusCode = statusCode;
        this.message = message;
        this.detalhes = detalhes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErroLog erroLog = (ErroLog) o;
        return id.equals(erroLog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
