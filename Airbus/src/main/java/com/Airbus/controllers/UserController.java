package com.Airbus.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Airbus.services.UserService;
import com.Airbus.entity.User;


@RestController
@RequestMapping("/User")
public class UserController {
	
	UserService userServ;
	
	public UserController(UserService service) {
		super();
		this.userServ = service;
	}
	
	//create or register user
		@PostMapping("/register")
		public ResponseEntity<User> User(@RequestBody User user) {
			    User usr= userServ.addUser(user);
		      
		        return new ResponseEntity<>(usr, HttpStatus.CREATED);
		    }
		
		//update employee
		@PutMapping("/update")
		public ResponseEntity<User> updateUser(@RequestBody User user) {
			   User usr= userServ.updateUser(user);
		      
		        return new ResponseEntity<>(usr, HttpStatus.OK);
		    }

}
