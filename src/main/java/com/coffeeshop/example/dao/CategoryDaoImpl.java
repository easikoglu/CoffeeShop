package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 */
@Repository
public class CategoryDaoImpl extends GenericDaoImpl<ProductCategoryJpaEntity,Long> implements CategoryDao {


    @Override
    public List<ProductCategoryJpaEntity> findParent() {
        Criteria criteria = currentSession().createCriteria(ProductCategoryJpaEntity.class);
         criteria.add(Restrictions.eq("parent.id", new Long(1)));
        return criteria.list();
    }
}
