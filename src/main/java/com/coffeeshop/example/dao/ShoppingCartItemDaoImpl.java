package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.shoppingcart.jpa.ShoppingCartItemJpaEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by easikoglu on 31/01/16.
 */
@Repository
public class ShoppingCartItemDaoImpl  extends GenericDaoImpl<ShoppingCartItemJpaEntity,Long> implements ShoppingCartItemDao {
}
