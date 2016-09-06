package com.coffeeshop.example.web.resource;

import com.coffeeshop.example.web.resource.visitor.ItemResource;
import com.coffeeshop.example.web.resource.visitor.ItemVisitor;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by easikoglu on 30/01/16.
 */
@XmlRootElement
public class AdditionResource implements ItemResource{

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    Long id;
    String name;
    BigDecimal price;

    public AdditionResource() {
    }

    public AdditionResource(Long id, String name, BigDecimal price) {
        this.id=id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal accept(ItemVisitor visitor) {
        return visitor.visit(this);
    }
}
