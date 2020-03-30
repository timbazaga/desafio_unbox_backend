package com.unboxculture.desafio.api.resources;

import com.unboxculture.desafio.core.entity.Filme;
import com.unboxculture.desafio.core.entity.Genero;
import com.unboxculture.desafio.core.service.FilmeService;
import com.unboxculture.desafio.core.service.GeneroService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/filmes")
@Api(value = "Filmes", tags = "Filmes")
public class FilmeResource {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> teste() {
        return filmeService.listar();
    }
}
