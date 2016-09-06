package com.coffeeshop.example.data;


import com.coffeeshop.example.util.StartMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DemoDataGenerator {


    @Autowired
    ProductGenerator productGenerator;
    @Autowired
    CategoryGenerator categoryGenerator;
    @Autowired
    UserGenerator userGenerator;
    @Autowired
    AdditionGenerator additionGenerator;

    @Async
    public void generateAllSystemData() {

        if (StartMode.isDevelopment()) {

            categoryGenerator.generate();
            additionGenerator.generate();
            productGenerator.generate();
            userGenerator.generate();


        }
    }

}
