package com.coffeeshop.example.services.impl;

import com.coffeeshop.example.models.order.jpa.OrderJpaEntity;
import com.coffeeshop.example.services.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by easikoglu on 31/01/16.
 */
@Service
@Transactional
public class OrderServiceImpl extends GenericServiceImpl<OrderJpaEntity,Long> implements OrderService {
}
