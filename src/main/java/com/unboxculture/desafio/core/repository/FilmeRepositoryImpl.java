package com.unboxculture.desafio.core.repository;

import com.unboxculture.desafio.arquitetura.repository.BaseRepository;
import com.unboxculture.desafio.core.entity.Filme;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public class FilmeRepositoryImpl extends BaseRepository<Filme, Long> implements FilmeRepositoryQuery {

}
