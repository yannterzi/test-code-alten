package com.meriakri.expedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExpediaAssigment18Application extends SpringBootServletInitializer {
    
    public static void main(String[] args) {
	SpringApplication.run(ExpediaAssigment18Application.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(ExpediaAssigment18Application.class);
    }
}
