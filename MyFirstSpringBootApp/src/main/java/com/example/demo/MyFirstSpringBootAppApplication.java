package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MyFirstSpringBootAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyFirstSpringBootAppApplication.class, args);
		
		System.out.println("Welcome to boot !");
		
		Alien alien = context.getBean(Alien.class);
		alien.show();
		
		Alien alien1 = context.getBean(Alien.class);
		alien1.show();
	}

}
