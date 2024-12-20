package com.learning.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	public CommandLineRunner commandLineRunner(String[] args){
		return runner -> {
			System.out.println("Hello World!");
		};
	}
}
