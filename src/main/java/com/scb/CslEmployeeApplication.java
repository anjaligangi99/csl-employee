package com.scb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CslEmployeeApplication {

	private static Logger logger = LogManager.getLogger(CslEmployeeApplication.class);
	public static void main(String[] args) {
		
		logger.info("Spring Boot Application Started ......");
		SpringApplication.run(CslEmployeeApplication.class, args);
	}

}
