package com.coffeeshop.example.data;

import com.coffeeshop.example.models.addition.jpa.AdditionJpaEntity;
import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.product.Product;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;
import com.coffeeshop.example.services.AdditionService;
import com.coffeeshop.example.services.ProductService;
import com.coffeeshop.example.web.resource.AdditionResource;
import com.coffeeshop.example.web.resource.ProductResource;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AdditionGenerator extends DataGenerator {

    private static final String ADDITION_FILE = "additions.txt";


    @Autowired
    AdditionService additionService;
    @Autowired
    ProductService productService;

    @Override
    void generate() {

        List<String> lines = file2List(ADDITION_FILE);


        for (String product : lines) {

            String[] array = product.split("=");


            String productAsString = array[1];
            AdditionResource resource = new Gson().fromJson(productAsString, AdditionResource.class);

            AdditionJpaEntity additionJpaEntity = new AdditionJpaEntity();

            additionJpaEntity.setName(resource.getName());
            additionJpaEntity.setPrice(resource.getPrice());
            additionService.add(additionJpaEntity);
        }

    }

}
