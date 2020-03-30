package com.unboxculture.desafio.core.service;

import com.unboxculture.desafio.arquitetura.service.BaseService;
import com.unboxculture.desafio.core.entity.Genero;
import com.unboxculture.desafio.core.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService extends BaseService<Genero, Integer> {

    @Autowired
    private GeneroRepository repository;

    public List<Genero> listar() {
        return repository.findAll();
    }

}

