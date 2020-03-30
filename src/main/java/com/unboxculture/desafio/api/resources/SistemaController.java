package com.unboxculture.desafio.api.resources;

import com.unboxculture.desafio.core.entity.Genero;
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
@RequestMapping("/teste")
@Api(value = "Sistema", tags = "Sistema")
public class SistemaController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> teste() {
        return generoService.listar();
    }
}
