package com.example.hello_world;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);

	public static void main(String[] args) {
		logger.warn("=== SYSTEM STARTING ===");
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
