package com.springboothibernate.hibernate.dao.abstraction;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<PK extends Serializable, T> {

    void save(T entity);

    T getById(PK id);

    List<T> getAll();

    List<T> getAllApproved();

    void update(T entity);

    void detach(T entity);

    void deleteById(PK id);

    void deleteEntity(T entity);

    /**
     * Возвращает список сущностей, в имени которых содержится переданный параметр
     *
     * @return List<Song>
     */
    List<T> findByNameContaining(String param);

    T getProxy(Class<T> entityClass, PK id);

}
