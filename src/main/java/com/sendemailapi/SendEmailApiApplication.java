package com.sendemailapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendEmailApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendEmailApiApplication.class, args);
		
		System.out.println("Started.......");
	}

}
