package com.coffeeshop.example.web.resource.visitor;

import com.coffeeshop.example.web.resource.AdditionResource;
import com.coffeeshop.example.web.resource.ProductResource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by easikoglu on 30/01/16.
 */
@Service
public class ItemVisitorImpl implements ItemVisitor {


    @Override
    public BigDecimal visit(ProductResource product) {
        if(product.getPrice().compareTo(new BigDecimal("12")) == -1){ //small then 12
            return product.getPrice();
        }else {
            return product.getPrice().multiply(new BigDecimal(0.75));
        }

    }

    @Override
    public BigDecimal visit(AdditionResource addition) {
        if(addition.getPrice().compareTo(new BigDecimal("12")) == -1){ //small then 12
            return addition.getPrice();
        }else {
            return addition.getPrice().multiply(new BigDecimal(0.75));
        }
    }
}
