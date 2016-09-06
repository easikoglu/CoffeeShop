package com.coffeeshop.example.web.resource;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by easikoglu on 31/01/16.
 */
@XmlRootElement
public class ShoppingCartResource {

    ProductResource product;
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    List<AdditionResource> additions = new ArrayList<>();

    public ProductResource getProduct() {
        return product;
    }

    public void setProduct(ProductResource product) {
        this.product = product;
    }

    public List<AdditionResource> getAdditions() {
        return additions;
    }

    public void setAdditions(List<AdditionResource> additions) {
        this.additions = additions;
    }
}
