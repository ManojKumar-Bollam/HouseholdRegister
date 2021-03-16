package com.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.register")
@SpringBootApplication
public class RegisterSystemForHouseholdSocietyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterSystemForHouseholdSocietyApplication.class, args);
	}

}
