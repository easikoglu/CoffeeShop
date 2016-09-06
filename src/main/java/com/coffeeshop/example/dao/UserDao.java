package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.user.jpa.UserJpaEntity;

/**
 * Created by easikoglu on 30/01/16.
 */
public interface UserDao extends GenericDao<UserJpaEntity,Long> {
    UserJpaEntity findByName(String name);
}
