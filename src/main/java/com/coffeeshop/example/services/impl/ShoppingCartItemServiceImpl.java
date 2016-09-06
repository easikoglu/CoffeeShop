package com.coffeeshop.example.services.impl;

import com.coffeeshop.example.models.shoppingcart.jpa.ShoppingCartItemJpaEntity;
import com.coffeeshop.example.models.shoppingcart.jpa.ShoppingCartJpaEntity;
import com.coffeeshop.example.services.ShoppingCartItemService;
import com.coffeeshop.example.services.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by easikoglu on 31/01/16.
 */
@Service
@Transactional
public class ShoppingCartItemServiceImpl extends GenericServiceImpl<ShoppingCartItemJpaEntity,Long> implements ShoppingCartItemService {
}
