package com.coffeeshop.example.models.user;

import com.coffeeshop.example.models.base.BaseDataModel;
import com.coffeeshop.example.models.shoppingcart.ShoppingCart;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface User extends BaseDataModel {

    String getName();

    void setName(String name);

    @Override
    public abstract void setId(Long id);

    @Override
    public abstract Long getId();

    ShoppingCart getShoppingCart();

    void setShoppingCart(ShoppingCart shoppingCart);
}
