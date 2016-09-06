package com.coffeeshop.example.models.user.jpa;

import com.coffeeshop.example.models.base.BaseJpaEntity;
import com.coffeeshop.example.models.shoppingcart.ShoppingCart;
import com.coffeeshop.example.models.shoppingcart.jpa.ShoppingCartJpaEntity;
import com.coffeeshop.example.models.user.User;

import javax.persistence.*;
import java.beans.Transient;
import java.io.Serializable;

/**
 * Created by easikoglu on 30/01/16.
 */
@Entity
@Table(name = "users")
public class UserJpaEntity extends BaseJpaEntity implements  Serializable {

    private String name;
    private Long id;


     @Column(name = "name", nullable = false, length = 25)
    public String getName() {
        return name;
    }

     public void setName(String name) {
        this.name = name;
    }

     public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Long getId() {
        return id;
    }
}
