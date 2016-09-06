package com.coffeeshop.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	DemoDataGenerator demoDataGenerator;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		demoDataGenerator.generateAllSystemData();
	}

}
