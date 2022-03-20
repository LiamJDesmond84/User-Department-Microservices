package com.liam.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liam.userservice.VO.ResponseTemplateVO;
import com.liam.userservice.models.User;
import com.liam.userservice.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		log.info("Controller: Creating User");
		return userServ.createUser(user);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Controller: getUserWithDepartment");
		return userServ.getUserWithDepartment(userId);
	}


}
