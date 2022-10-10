package com.example.app.firstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(FirstSpringBootApplication.class, args);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}}
