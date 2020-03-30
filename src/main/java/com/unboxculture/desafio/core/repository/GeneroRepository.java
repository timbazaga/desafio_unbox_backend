package com.unboxculture.desafio.core.repository;

import com.unboxculture.desafio.core.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>, GeneroRepositoryQuery {

}
