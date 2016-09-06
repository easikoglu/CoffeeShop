package com.coffeeshop.example.data;

import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.services.CategoryService;
import com.coffeeshop.example.util.ObjectUtil;
import com.coffeeshop.example.web.resource.CategoryResource;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class CategoryGenerator extends DataGenerator {

    private static final String CATEGORY_FILE = "categories.txt";

    @Autowired
    CategoryService categoryService;

    @Override
    void generate() {


        List<String> lines = file2List(CATEGORY_FILE);
        for (String cat : lines) {

            String[] array = cat.split("=");


            String categoryAsString = array[1];
            CategoryResource resource = new Gson().fromJson(categoryAsString, CategoryResource.class);

            ProductCategoryJpaEntity entity = new ProductCategoryJpaEntity();
            entity.setId(resource.getId());
            entity.setName(resource.getName());

            if (ObjectUtil.isNotNull(resource.getParentId())) {
                final ProductCategoryJpaEntity parent = categoryService.get(resource.getParentId());
                entity.setParent(parent);
            }

            categoryService.add(entity);


        }

    }

}
