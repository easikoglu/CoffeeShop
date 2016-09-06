package com.coffeeshop.example.services.impl;

import com.coffeeshop.example.dao.CategoryDao;
import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 */
@Service
@Transactional
public class CategoryServiceImpl  extends GenericServiceImpl<ProductCategoryJpaEntity,Long> implements CategoryService {


    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<ProductCategoryJpaEntity> findParent() {
        return categoryDao.findParent();
    }
}
