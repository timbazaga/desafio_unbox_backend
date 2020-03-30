package com.unboxculture.desafio.core.repository;

import com.unboxculture.desafio.arquitetura.repository.BaseRepository;
import com.unboxculture.desafio.core.entity.Genero;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public class GeneroRepositoryImpl extends BaseRepository<Genero, Integer> implements GeneroRepositoryQuery {

}
