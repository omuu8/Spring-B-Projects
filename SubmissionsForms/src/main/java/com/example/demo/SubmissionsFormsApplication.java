package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
// Scanning occurs from the class where it is declared
@SpringBootApplication
public class SubmissionsFormsApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SubmissionsFormsApplication.class);
	}
	public static void main(String[] args) {
		
		SpringApplication.run(SubmissionsFormsApplication.class, args);
	}

}
