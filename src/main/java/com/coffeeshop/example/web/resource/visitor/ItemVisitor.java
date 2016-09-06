package com.coffeeshop.example.web.resource.visitor;

import com.coffeeshop.example.web.resource.AdditionResource;
import com.coffeeshop.example.web.resource.ProductResource;

import java.math.BigDecimal;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface ItemVisitor {

    BigDecimal visit(ProductResource product);
    BigDecimal visit(AdditionResource addition);
}
