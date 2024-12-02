package com.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RestHospitalProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestHospitalProject2Application.class, args);
	}

}
