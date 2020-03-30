package com.unboxculture.desafio.core.entity;

import com.unboxculture.desafio.arquitetura.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "genero")
public class Genero extends BaseEntity<Genero, Integer> {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long codigoTheMovieDB;
    private String descricao;
}
