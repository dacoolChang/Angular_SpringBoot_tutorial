package com.example.demo.data.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.data.User;

@Component
public class UsersBean {
	
	List<User> users = new ArrayList<User>();
	public UsersBean() {
		users.add(new User("John"));
	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
