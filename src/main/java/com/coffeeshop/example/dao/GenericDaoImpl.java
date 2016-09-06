package com.coffeeshop.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<T, K extends Serializable>
        implements GenericDao<T, K> {
    @Autowired
    private SessionFactory sessionFactory;
     
    protected Class<? extends T> daoType;
     
    /**
    * By defining this class as abstract, we prevent Spring from creating 
    * instance of this class If not defined as abstract, 
    * getClass().getGenericSuperClass() would return Object. There would be 
    * exception because Object class does not hava constructor with parameters.
    */
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
     
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
     
    @Override
    public void add(T entity) {
        currentSession().save(entity);
    }
     
    @Override
    public void saveOrUpdate(T entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void update(T entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void remove(T entity) {
        currentSession().delete(entity);
    }
     
    @Override
    public T find(K key) {
        return (T) currentSession().get(daoType, key);
    }
     
    @Override
    public List<T> getAll() {
        return currentSession().createCriteria(daoType).list();
    }
}