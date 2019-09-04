package com.scb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CslUserEmployeeAppln {

	private static Logger logger = LogManager.getLogger(CslUserEmployeeAppln.class);
	
	public static void main(String[] args) {
		logger.info("");
		SpringApplication.run(CslUserEmployeeAppln.class, args);
		
	}
}
