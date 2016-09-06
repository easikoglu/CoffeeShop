package com.coffeeshop.example.data;

import com.coffeeshop.example.models.category.ProductCategory;
import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;
import com.coffeeshop.example.services.CategoryService;
import com.coffeeshop.example.services.ProductService;
import com.coffeeshop.example.web.resource.ProductResource;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductGenerator extends DataGenerator {

    private static final String PRODUCT_FILE = "products.txt";


    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Override
    void generate() {


        List<String> lines = file2List(PRODUCT_FILE);


        for (String product : lines) {

            String[] array = product.split("=");


            String productAsString = array[1];
            ProductResource resource = new Gson().fromJson(productAsString, ProductResource.class);

            final ProductCategoryJpaEntity categoryJpaEntity = categoryService.get(resource.getCategoryId());

            ProductJpaEntity entity = new ProductJpaEntity();
            entity.setName(resource.getName());
            entity.setPrice(resource.getPrice());
            entity.setCategory((ProductCategory) categoryJpaEntity);
            productService.add(entity);
        }
    }


}
