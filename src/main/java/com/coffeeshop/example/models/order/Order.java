package com.coffeeshop.example.models.order;

import com.coffeeshop.example.models.base.BaseDataModel;
import com.coffeeshop.example.models.shoppingcart.ShoppingCart;

import java.math.BigDecimal;

/**
 * Created by easikoglu on 31/01/16.
 */
public interface Order extends BaseDataModel {

    @Override
    public abstract void setId(Long id);

    @Override
    public abstract Long getId();


    ShoppingCart getShoppingCart();

    void setShoppingCart(ShoppingCart shoppingCart);
}
