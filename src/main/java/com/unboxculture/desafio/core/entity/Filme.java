package com.unboxculture.desafio.core.entity;

import com.unboxculture.desafio.arquitetura.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "filme")
public class Filme extends BaseEntity<Filme, Long> {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String tituloOriginal;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "filme_genero", inverseJoinColumns = {@JoinColumn(name = "genero_id")})
    private List<Genero> generos;
}
