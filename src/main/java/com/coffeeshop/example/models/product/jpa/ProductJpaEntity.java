package com.coffeeshop.example.models.product.jpa;

import com.coffeeshop.example.models.addition.Addition;
import com.coffeeshop.example.models.addition.jpa.AdditionJpaEntity;
import com.coffeeshop.example.models.base.BaseJpaEntity;
import com.coffeeshop.example.models.category.ProductCategory;
import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by easikoglu on 30/01/16.
 * This class mysql based jpa entity. look at the id definition.
 */
@Entity
@Table(name = "product",uniqueConstraints = {
        @UniqueConstraint(columnNames = "PRODUCT_ID")})

public class ProductJpaEntity extends BaseJpaEntity implements Product, Serializable {


    private Long id;
    private String name;
    private BigDecimal price;
    private ProductCategoryJpaEntity category;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID",unique = true)
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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ProductCategoryJpaEntity.class)
    @JoinColumn(name = "category_id", nullable = false)
    public ProductCategory getCategory() {
        return (ProductCategory) category;
    }

    @Override
    public void setCategory(ProductCategory category) {
        this.category = (ProductCategoryJpaEntity) category;
    }


}
