package com.unboxculture.desafio.arquitetura.repository;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class BaseRepository<T, S> {


    @PersistenceContext
    private EntityManager manager;

    protected EntityManager getManager() {
        return manager;
    }

    protected Session getSession() {
        return manager.unwrap(Session.class);
    }

    protected Query setAllParameters(Query query, Map<String, Object> parameters) {
        parameters.forEach(query::setParameter);
        return query;
    }

    public void excluirTodos(List<T> elementos, Class<T> clazz) {
        if (CollectionUtils.isEmpty(elementos)) {
            return;
        }

        StringBuilder jpql = new StringBuilder();
        jpql
                .append(" DELETE ")
                .append(" FROM " + clazz.getName() + " e ")
                .append(" WHERE e in :eList ");

        getManager()
                .createQuery(jpql.toString())
                .setParameter("eList", elementos)
                .executeUpdate();
    }

    public void excluir(T entidade) {
        getManager().remove(entidade);
    }

    public T salvar(T entidade) {
        getSession().persist(entidade);
        return entidade;
    }

    public T update(T entidade) {
        getSession().update(entidade);
        return entidade;
    }


}
