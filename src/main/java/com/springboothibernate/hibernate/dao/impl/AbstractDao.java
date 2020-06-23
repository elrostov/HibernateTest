package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.model.compositeKey.embeddable.EmbeddableClassA;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Transactional/*(propagation = Propagation.MANDATORY)*/
public abstract class AbstractDao<PK extends Serializable, T> {

    @PersistenceContext
    EntityManager em;

    private final Class<T> persistentClass;

    AbstractDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public void save(T entity) {
        em.persist(entity);
        System.out.println(entity);
    }

    public void detach(T entity) {
        em.detach(entity);
        System.out.println(entity);
    }

    public T getById(PK id) {
        return em.find(persistentClass, id);
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public void deleteById(PK id) {
        T entity = em.find(persistentClass, id);
        em.remove(entity);
    }

    public void deleteEntity(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
//        em.remove(entity);
        System.out.println(entity);
    }

    /**
     * возвращает List объектов, в имени которых содержиться передаваемый парраметр
     * Если у обекта нет поля 'name', возвращает null
     *
     * @return List
     */
    public List<T> findByNameContaining(String param) {
        try {
            String className = persistentClass.getName();

            String hql = "FROM " + className + " o WHERE o.name LIKE :param";

            TypedQuery<T> query = em.createQuery(hql, persistentClass);
            // знак % обозначает, что перед передаваемым значение может быть, или колько угодно символов, или ноль.
            query.setParameter("param", "%" + param + "%");

            return query.getResultList();

        } catch (Exception e) {
            System.out.println("сообщение об ошибке: " + e.getMessage());
            return null;
        }
    }

    public List<T> getAll() {
        String genericClassName = persistentClass.toGenericString();
        genericClassName = genericClassName.substring(genericClassName.lastIndexOf('.') + 1);
        String hql = "FROM " + genericClassName;
        TypedQuery<T> query = em.createQuery(hql, persistentClass);
        List<T> list = query.getResultList();
        list.forEach(System.out::println);
        return list;
    }

    public List<T> getAllApproved() {
        String genericClassName = persistentClass.toGenericString();
        genericClassName = genericClassName.substring(genericClassName.lastIndexOf('.') + 1);
        String hql = "FROM " + genericClassName + " as c WHERE c.isApproved = true";
        TypedQuery<T> query = em.createQuery(hql, persistentClass);
        return query.getResultList();
    }

    public T getProxy(Class<T> entityClass, PK id) {
        T t1 = em.getReference(entityClass, id);
        System.out.println(t1);
        T t2 = em.getReference(entityClass, id);
        System.out.println(t2);
        return t1;
    }
}