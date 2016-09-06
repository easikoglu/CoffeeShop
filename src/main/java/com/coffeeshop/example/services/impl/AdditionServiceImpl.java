package com.coffeeshop.example.services.impl;

import com.coffeeshop.example.models.addition.jpa.AdditionJpaEntity;
import com.coffeeshop.example.services.AdditionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by easikoglu on 30/01/16.
 */
@Service
@Transactional
public class AdditionServiceImpl extends GenericServiceImpl<AdditionJpaEntity,Long> implements AdditionService {
}
