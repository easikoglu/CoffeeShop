package com.coffeeshop.example.services.impl;

import com.coffeeshop.example.dao.ProductDao;
import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;
import com.coffeeshop.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 */
@Service
@Transactional
public class ProductServiceImpl extends GenericServiceImpl<ProductJpaEntity,Long>  implements ProductService {


    @Autowired
    private ProductDao productDao;


    @Override
    public List<ProductJpaEntity> findByCategory(ProductCategoryJpaEntity categoryJpaEntity) {
        return productDao.findByCategory(categoryJpaEntity);
    }
}
