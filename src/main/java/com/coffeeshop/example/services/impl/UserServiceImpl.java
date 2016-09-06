package com.coffeeshop.example.services.impl;

import com.coffeeshop.example.dao.UserDao;
import com.coffeeshop.example.models.user.jpa.UserJpaEntity;
import com.coffeeshop.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by easikoglu on 30/01/16.
 */
@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<UserJpaEntity,Long> implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserJpaEntity findByName(String name) {
        return userDao.findByName(name);
    }
}
