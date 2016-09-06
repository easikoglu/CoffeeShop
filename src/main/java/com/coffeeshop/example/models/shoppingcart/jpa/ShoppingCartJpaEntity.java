package com.coffeeshop.example.models.shoppingcart.jpa;

import com.coffeeshop.example.models.base.BaseJpaEntity;
import com.coffeeshop.example.models.category.ProductCategory;
import com.coffeeshop.example.models.order.jpa.OrderJpaEntity;
import com.coffeeshop.example.models.product.Product;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;
import com.coffeeshop.example.models.shoppingcart.ShoppingCart;
import com.coffeeshop.example.models.shoppingcart.ShoppingCartItem;
import com.coffeeshop.example.models.user.User;
import com.coffeeshop.example.models.user.jpa.UserJpaEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by easikoglu on 30/01/16.
 * This class mysql based jpa entity. look at the id definition.
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCartJpaEntity extends BaseJpaEntity implements ShoppingCart, Serializable {


    private Long id;
    private List<ShoppingCartItemJpaEntity> items = new ArrayList<>();
    private BigDecimal totalPrice;
    private BigDecimal discountPrice;
    private BigDecimal lastPrice;
    private UserJpaEntity user;
    private OrderJpaEntity order;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Override
    @Transient
    public void setId(final Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = UserJpaEntity.class)
    @JoinColumn(name = "user_id", nullable = false)
    public UserJpaEntity getUser() {
        return user;
    }

    public void setUser(UserJpaEntity user) {
        this.user =  user;
    }

    @Override
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingCart", fetch = FetchType.EAGER, targetEntity = ShoppingCartItemJpaEntity.class)
    public List<? extends ShoppingCartItem> getItems() {
        return items;
    }

    @Transient
    public void setItems(List<? extends ShoppingCartItem> items) {
        this.items = (List<ShoppingCartItemJpaEntity>) items;
    }

    @Override
    @Column(name = "TOTAL_PRICE")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    @Column(name = "DISCOUNT_PRICE")
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    @Column(name = "LAST_PRICE")
    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    @Override
    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public OrderJpaEntity getOrder() {
        return order;
    }

    public void setOrder(OrderJpaEntity orderJpaEntity) {
        this.order = orderJpaEntity;
    }
}
