package com.coffeeshop.example.services;

import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;

import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface CategoryService extends GenericService<ProductCategoryJpaEntity, Long> {

    List<ProductCategoryJpaEntity> findParent();
}
