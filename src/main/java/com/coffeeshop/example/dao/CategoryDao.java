package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;

import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 */

public interface CategoryDao extends GenericDao<ProductCategoryJpaEntity,Long> {

    List<ProductCategoryJpaEntity> findParent();
}
