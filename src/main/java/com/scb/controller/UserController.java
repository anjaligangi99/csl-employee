package com.scb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scb.entity.User;
import com.scb.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	public List<User> saveUser(@RequestBody List<User> user) {
		
		return userService.saveUser(user);
	}
	

	
}
