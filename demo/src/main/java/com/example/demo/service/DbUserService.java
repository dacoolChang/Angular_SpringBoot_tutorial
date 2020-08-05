package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dbfield.DbUser;
import com.example.demo.repository.DbUserRepository;

@Service
public class DbUserService {
	@Autowired
	DbUserRepository userRep;
	
	public void initialData() {
		DbUser user = new DbUser();
		user.setName("Elmo");
		userRep.save(user);
	}
	
	public List<DbUser> getUsers() {
		return userRep.findAll();
	}
	
}
