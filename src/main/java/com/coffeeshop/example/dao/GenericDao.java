package com.coffeeshop.example.dao;

import java.util.List;

public interface GenericDao<T,K> {
    public void add(T entity) ;
    public void saveOrUpdate(T entity) ;
    public void update(T entity) ;
    public void remove(T entity);
    public T find(K key);
    public List<T> getAll() ;
}