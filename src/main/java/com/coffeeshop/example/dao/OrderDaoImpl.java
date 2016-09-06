package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.order.jpa.OrderJpaEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by easikoglu on 31/01/16.
 */
@Repository
public class OrderDaoImpl extends  GenericDaoImpl<OrderJpaEntity,Long> implements OrderDao {
}
