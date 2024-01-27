package com.Airbus.controllers;

import java.util.Optional;
import java.util.Set;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Airbus.services.UserService;

import com.Airbus.entity.User;
import com.Airbus.entity.Passengers;
import com.Airbus.entity.Flight;
import com.Airbus.Dao.UserDao;
import com.Airbus.Dao.PassengerDao;
import com.Airbus.Dao.FlightDao;
@RestController
@RequestMapping("/User")
public class UserController {
	
	UserService userServ;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	PassengerDao passengerdao;
	
	@Autowired
	FlightDao flightdao;
	
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
				
	   //search user by email
				@GetMapping("/detail/{mail}")
				public ResponseEntity<User> UserByMail(@PathVariable("mail") String mail){
					User user=userServ.findUserByMail(mail);
					/*if(employee==null) {
						throw new ItemNotFoundException("Admin with mail" + mail + " is not Found.Pls Give another mail!");
					}*/
					
					 return new ResponseEntity<>(user, HttpStatus.OK);
				
				}
				
				//Add a new passenger for User
				@PostMapping("/createPass/{id}")
				public ResponseEntity<Passengers> addPassenger(@RequestBody Passengers passenger, 
						@PathVariable("id") Integer userId){
					
					 
					
					User user=userServ.findUserbyID(userId);
					//passenger.setUser(user);
					user.addPassenger(passenger);
					//passenger.setUser(user);
					userdao.save(user);				
					
					
					return new ResponseEntity<>(passenger, HttpStatus.OK);
					
			           // return new ItemNotFoundException("Employee with id" + id + " is not Found.Pls Give another Id!");
	
				}	
				//user login
				@PostMapping("/userLogin")
				public ResponseEntity<User> loginUser(@RequestBody User us){
					User user = userServ.showUserUsingLogin(us.getUseremail(), us.getUserpassword());
					return ResponseEntity.ok(user);
				}
				
				
				//Delete Passenger
				@DeleteMapping("/delete/{id}/{pid}")
				public ResponseEntity<Passengers> deletePassenger(@PathVariable("id") Integer userId,
						@PathVariable("pid") Integer passId){
					
					 
					
					User user=userServ.findUserbyID(userId);
					Optional<Passengers> temppass= passengerdao.findById(passId);
					Passengers passenger= temppass.get();
					passengerdao.save(passenger);
					user.addPassenger(passenger);
					userdao.save(user);
					
					return new ResponseEntity<>(passenger, HttpStatus.OK);
					
			           // return new ItemNotFoundException("Employee with id" + id + " is not Found.Pls Give another Id!");
	
				}
				
				@GetMapping("/getPass/{id}")//get passengers under a user
				public ResponseEntity<Set<Passengers>> getPassengers(@PathVariable("id") Integer userId){
					User user=userServ.findUserbyID(userId);
					
					return new ResponseEntity<>(user.getPassengers(), HttpStatus.OK);
					
					
				}
				
				@GetMapping("/viewFlights")
				public ResponseEntity<List<Flight>> getFlights(){
					List<Flight> flights= flightdao.findAll();
					
					return new ResponseEntity<>(flights, HttpStatus.OK);
				}

}
