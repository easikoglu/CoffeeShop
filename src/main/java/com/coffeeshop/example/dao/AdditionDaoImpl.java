package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.addition.jpa.AdditionJpaEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by easikoglu on 30/01/16.
 */
@Repository
public class AdditionDaoImpl extends GenericDaoImpl<AdditionJpaEntity,Long> implements AdditionDao {
}
