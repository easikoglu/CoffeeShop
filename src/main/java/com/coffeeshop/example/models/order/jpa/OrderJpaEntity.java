package com.coffeeshop.example.models.order.jpa;

import com.coffeeshop.example.models.base.BaseJpaEntity;
import com.coffeeshop.example.models.order.Order;
import com.coffeeshop.example.models.shoppingcart.ShoppingCart;
import com.coffeeshop.example.models.shoppingcart.jpa.ShoppingCartJpaEntity;

import javax.persistence.*;

/**
 * Created by easikoglu on 31/01/16.
 */
@Entity
@Table(name = "orders")
public class OrderJpaEntity extends BaseJpaEntity implements Order {

    private Long id;
    private ShoppingCartJpaEntity shoppingCart;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ORDER_ID",unique = true)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


    @Override
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL,targetEntity = ShoppingCartJpaEntity.class)
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = (ShoppingCartJpaEntity) shoppingCart;
    }
}
