package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dbfield.DbUser;
import com.example.demo.service.DbUserService;

@Component
public class DemoCommandLineRunner implements CommandLineRunner {

	@Autowired
	DbUserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		if (userService.getUsers().size() == 0) {
			userService.save(new DbUser("Elmo"));
		}
	}

}
