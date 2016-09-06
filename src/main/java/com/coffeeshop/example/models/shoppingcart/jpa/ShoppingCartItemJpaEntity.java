package com.coffeeshop.example.models.shoppingcart.jpa;

import com.coffeeshop.example.models.addition.Addition;
import com.coffeeshop.example.models.addition.jpa.AdditionJpaEntity;
import com.coffeeshop.example.models.base.BaseJpaEntity;
import com.coffeeshop.example.models.product.Product;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;
import com.coffeeshop.example.models.shoppingcart.ShoppingCart;
import com.coffeeshop.example.models.shoppingcart.ShoppingCartItem;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 * This class mysql based jpa entity. look at the id definition.
 */
@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItemJpaEntity extends BaseJpaEntity implements ShoppingCartItem, Serializable {


    private Long id;
    private ShoppingCartJpaEntity shoppingCart;
    private ProductJpaEntity product;
    private List<AdditionJpaEntity> additions;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ProductJpaEntity.class)
    @JoinColumn(name = "product_id", nullable = false)
    public ProductJpaEntity getProduct() {
        return product;
    }

    @Override
    public void setProduct(Product product) {
        this.product = (ProductJpaEntity) product;
    }


    @Override
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ShoppingCartJpaEntity.class)
    @JoinColumn(name = "cart_id", nullable = false)
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void setShoppingCart(ShoppingCart cart) {
        this.shoppingCart = (ShoppingCartJpaEntity) cart;
    }


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(name = "shopping_card_item_additions", joinColumns = {
            @JoinColumn(name = "ITEM_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ADDITION_ID",
                    nullable = false, updatable = false)})
    public List<AdditionJpaEntity> getAdditions() {
        return additions;
    }

    public void setAdditions(List<AdditionJpaEntity> items) {
        this.additions = items;
    }

}
