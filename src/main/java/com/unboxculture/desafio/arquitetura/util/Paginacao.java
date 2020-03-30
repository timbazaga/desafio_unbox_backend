package com.unboxculture.desafio.arquitetura.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paginacao {

    @Min(1L)
    int size = 10;

    @Min(0L)
    int page = 0;

    public Pageable toPageable() {
        return PageRequest.of(page, size);
    }
}
