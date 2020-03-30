package com.unboxculture.desafio.core.service;

import com.unboxculture.desafio.arquitetura.service.BaseService;
import com.unboxculture.desafio.core.entity.Filme;
import com.unboxculture.desafio.core.entity.Genero;
import com.unboxculture.desafio.core.repository.FilmeRepository;
import com.unboxculture.desafio.core.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService extends BaseService<Filme, Long> {

    @Autowired
    private FilmeRepository repository;

    public List<Filme> listar() {
        return repository.findAll();
    }
}

