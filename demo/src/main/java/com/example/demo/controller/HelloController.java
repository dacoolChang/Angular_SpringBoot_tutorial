
package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class HelloController {
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	@GetMapping("/hello")
	public String hello() {
		logger.info("Hello World Controller");
		return "hello world!!!";
	}
}
