package com.coffeeshop.example.models.addition.jpa;

import com.coffeeshop.example.models.addition.Addition;
import com.coffeeshop.example.models.base.BaseJpaEntity;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by easikoglu on 30/01/16.
 * This class mysql based jpa entity. look at the id definition.
 */
@Entity
@Table(name = "addition")
public class AdditionJpaEntity extends BaseJpaEntity implements Addition, Serializable {


    private Long id;
    private String name;
    private BigDecimal price;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDITION_ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "price", nullable = false, length = 25)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 25)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdditionJpaEntity)) return false;

        AdditionJpaEntity that = (AdditionJpaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
