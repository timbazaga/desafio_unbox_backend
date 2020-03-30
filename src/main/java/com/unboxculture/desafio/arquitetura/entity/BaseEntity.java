package com.unboxculture.desafio.arquitetura.entity;

import java.io.Serializable;

public abstract class BaseEntity<E, C> implements Serializable {

    protected abstract C getId();

}
