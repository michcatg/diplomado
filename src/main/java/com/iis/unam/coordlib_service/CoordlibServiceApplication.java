package com.iis.unam.coordlib_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CoordlibServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordlibServiceApplication.class, args);
	}

}
