package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;

@SpringBootApplication
@EnableEntityLinks
public class Application {
 
    public static void main(String[] args) {
    	System.out.println("Spring Boot begins...");
    	SpringApplication.run(Application.class, args);
    	System.out.println("Spring Boot started...");
        
    	//ApplicationContext ctx = 
        /*
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        */
    }
}