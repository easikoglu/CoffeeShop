package com.coffeeshop.example.models.product;

import com.coffeeshop.example.models.addition.Addition;
import com.coffeeshop.example.models.base.BaseDataModel;
import com.coffeeshop.example.models.category.ProductCategory;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface Product extends BaseDataModel {

    String getName();

    void setName(String name);

    @Override
    public abstract void setId(Long id);

    @Override
    public abstract Long getId();


    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    ProductCategory getCategory();

    void setCategory(ProductCategory category);



}
