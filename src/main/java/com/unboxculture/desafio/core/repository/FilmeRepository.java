package com.unboxculture.desafio.core.repository;

import com.unboxculture.desafio.core.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>, FilmeRepositoryQuery {

}
