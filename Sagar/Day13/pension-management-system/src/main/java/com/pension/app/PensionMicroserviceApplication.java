package com.pension.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pension.app.PensionRepository")
public class PensionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionMicroserviceApplication.class, args);
	}

}
