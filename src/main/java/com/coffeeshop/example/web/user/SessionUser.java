package com.coffeeshop.example.web.user;

import com.coffeeshop.example.web.resource.UserResource;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by easikoglu on 30/01/16.
 */
@XmlRootElement
public class SessionUser {
    String name;
    Long id;
    Long shoppingCartId;



    public SessionUser(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }
}
