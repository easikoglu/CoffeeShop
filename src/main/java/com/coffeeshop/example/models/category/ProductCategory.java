package com.coffeeshop.example.models.category;

import com.coffeeshop.example.models.base.BaseDataModel;
import com.coffeeshop.example.models.product.Product;

import java.util.Set;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface ProductCategory extends BaseDataModel {

    String getName();

    void setName(String name);

    @Override
    public abstract void setId(Long id);

    @Override
    public abstract Long getId();

    Set<? extends Product> getProducts();

    void setProducts(Set<? extends Product> products);

    Set<? extends ProductCategory> getChildren();

    void setChildren(Set<? extends ProductCategory> children);

    ProductCategory getParent();

    void setParent(ProductCategory parent);
}
