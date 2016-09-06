package com.coffeeshop.example.services.impl;

import com.coffeeshop.example.dao.GenericDao;
import com.coffeeshop.example.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class GenericServiceImpl<T, K>
        implements GenericService<T, K> {

    @Autowired
    private GenericDao<T, K> genericDao;
 
    public GenericServiceImpl(GenericDao<T,K> genericDao) {
        this.genericDao=genericDao;
    }
 
    public GenericServiceImpl() {
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(T entity) {
        genericDao.saveOrUpdate(entity);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> getAll() {
        return genericDao.getAll();
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T get(K id) {
        return genericDao.find(id);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(T entity) {
        genericDao.add(entity);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T entity) {
        genericDao.update(entity);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(T entity) {
        genericDao.remove(entity);
    }
}