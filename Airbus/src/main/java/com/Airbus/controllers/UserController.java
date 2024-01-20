package com.Airbus.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Airbus.services.UserService;

import com.Airbus.entity.User;
import com.Airbus.Dao.UserDao;

@RestController
@RequestMapping("/User")
public class UserController {
	
	ad userServ;
	
	@Autowired
	UserDao userdao;
	
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
		
		//update user
		@PutMapping("/update/{id}")
		public ResponseEntity<User> updateUser(@PathVariable("id") Integer userid, @RequestBody User usr) {
			    User user=userServ.findUserbyID(userid);
			    
			    user.setUsername(usr.getUsername());
				user.setUserpassword(usr.getUserpassword());
				user.setUserphonenumber(usr.getUserphonenumber());
			    userdao.save(user);
			   //User usr= userServ.updateUser(user);
		      
		        return new ResponseEntity<>(user, HttpStatus.OK);
		    }
		
		//search user by id
				@GetMapping("/details/{id}")
				public ResponseEntity<User> UserById(@PathVariable("id") Integer userid){
					//List<Employee> employees= adminserv.findEmployeeByName(name);
					User user=userServ.findUserbyID(userid);
					
					 /*if(user==null) {
						throw new ItemNotFoundException("Admin with mail" + userid + " is not Found.Pls Give another mail!");
					}*/
					
					 return new ResponseEntity<>(user, HttpStatus.OK);
					
				}

}
