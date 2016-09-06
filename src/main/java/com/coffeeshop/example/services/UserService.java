package com.coffeeshop.example.services;

import com.coffeeshop.example.models.user.jpa.UserJpaEntity;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface UserService extends GenericService<UserJpaEntity,Long> {
    UserJpaEntity findByName(String name);
}
