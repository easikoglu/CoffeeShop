package com.coffeeshop.example.models.shoppingcart;

import com.coffeeshop.example.models.base.BaseDataModel;
import com.coffeeshop.example.models.product.Product;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface ShoppingCartItem extends BaseDataModel {

    @Override
    Long getId();

    @Override
    void setId(Long id);


    Product getProduct();

    void setProduct(Product product);


    ShoppingCart getShoppingCart();

    void setShoppingCart(ShoppingCart cart);
}
