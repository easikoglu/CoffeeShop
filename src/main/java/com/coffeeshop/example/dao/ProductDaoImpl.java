package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;
import com.coffeeshop.example.models.user.jpa.UserJpaEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 */
@Repository
public class ProductDaoImpl extends GenericDaoImpl<ProductJpaEntity,Long> implements ProductDao {

    @Override
    public List<ProductJpaEntity> findByCategory(ProductCategoryJpaEntity categoryJpaEntity) {
        Criteria criteria = currentSession().createCriteria(ProductJpaEntity.class);
        criteria.add(Restrictions.eq("category.id", categoryJpaEntity.getId()));
        return criteria.list();
    }
}
