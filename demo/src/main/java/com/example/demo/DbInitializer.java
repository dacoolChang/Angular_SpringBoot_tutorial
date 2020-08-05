package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.service.DbUserService;

@Component
@Order(value=1)
public class DbInitializer implements CommandLineRunner{
	private static Logger logger = LoggerFactory.getLogger(DbInitializer.class);
	@Autowired
	DbUserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		logger.debug("runner2 started");
		System.out.println("user service initial");
		userService.initialData();
	}

}
