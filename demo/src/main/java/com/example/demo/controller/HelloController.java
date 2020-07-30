
package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Result;
import com.example.demo.data.User;
import com.example.demo.data.bean.UsersBean;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class HelloController {
	
	@Autowired
	UsersBean users;
	
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	@GetMapping("/hello")
	public ResponseEntity<List<User>> hello() {
		logger.info("Hello World Controller");
		return ResponseEntity.ok(users.getUsers());
	}
	
	@PutMapping("/hello")
	public ResponseEntity<Result> updateHello(@RequestBody String description) {
		logger.info("Update Hello World Controller");
		String[] dataSplit = description.split(",");
		if (dataSplit.length > 1) {
			for (User u : users.getUsers()) {
				if(dataSplit[0].equalsIgnoreCase(u.getName())) {
					u.setDescription(dataSplit[1]);
					Result result = new Result(); 
					result.setCode(0);
					result.setMesg("update user description success!!");
					return ResponseEntity.ok(result);
				}
			}
			Result result = new Result(); 
			result.setCode(0);
			result.setMesg("There is no user name is "+dataSplit[0]);
			return ResponseEntity.ok(result);

		} else {
			Result result = new Result(); 
			result.setCode(1);
			result.setMesg("update user description failed!!");
			return ResponseEntity.ok(result);
		}
		
	}
	
	@PostMapping("/hello")
	public ResponseEntity<Result> addHello(@RequestBody String name) {
		logger.info("Add Hello World Controller");
		users.getUsers().add(new User(name));
		Result result = new Result(); 
		result.setCode(0);
		result.setMesg("Add user success!!!");
		return ResponseEntity.ok(result);
	}
}
