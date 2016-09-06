package com.coffeeshop.example.data;

import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.user.jpa.UserJpaEntity;
import com.coffeeshop.example.services.GenericService;
import com.coffeeshop.example.services.UserService;
import com.coffeeshop.example.util.ObjectUtil;
import com.coffeeshop.example.web.resource.CategoryResource;
import com.coffeeshop.example.web.resource.UserResource;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGenerator extends DataGenerator {

    private static final String USER_FILE = "users.txt";

    @Autowired
    UserService userService;


    @Override
    void generate() {


        List<String> lines = file2List(USER_FILE);
        for (String cat : lines) {

            String[] array = cat.split("=");


            String categoryAsString = array[1];
            UserResource resource = new Gson().fromJson(categoryAsString, UserResource.class);

            UserJpaEntity entity = new UserJpaEntity();
            entity.setId(resource.getId());
            entity.setName(resource.getName());
            userService.add(entity);


        }

    }

}
