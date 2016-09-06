package com.coffeeshop.example.models.shoppingcart;

import com.coffeeshop.example.models.base.BaseDataModel;
import com.coffeeshop.example.models.user.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface ShoppingCart extends BaseDataModel{

    List<? extends  ShoppingCartItem> getItems();

    void setItems(List<? extends  ShoppingCartItem> items);


    public BigDecimal getTotalPrice();

    public void setTotalPrice(BigDecimal totalPrice);

    public BigDecimal getDiscountPrice();

    public void setDiscountPrice(BigDecimal discountPrice);

    public BigDecimal getLastPrice();

    public void setLastPrice(BigDecimal lastPrice);

    @Override
    Long getId();

    @Override
    void setId(Long id);
}
