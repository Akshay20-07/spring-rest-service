package com.example.restwebservices.springrestservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.example"})
@SpringBootApplication
public class SpringRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestServicesApplication.class, args);
	}

}
