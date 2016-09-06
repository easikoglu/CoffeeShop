package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.shoppingcart.jpa.ShoppingCartJpaEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by easikoglu on 31/01/16.
 */
@Repository
public class ShoppingCartDaoImpl extends GenericDaoImpl<ShoppingCartJpaEntity,Long> implements ShoppingCartDao {
}
