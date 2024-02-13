package com.Airbus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Airbus.entity.Admin;

import com.Airbus.Dao.AdminDao;
import com.Airbus.Dao.LocationDao;
import com.Airbus.services.AdminService;
import com.Airbus.services.LocationService;
import com.Airbus.services.FlightService;
import com.Airbus.entity.Location;
import com.Airbus.entity.Flight;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	AdminService adminserv;
	
	LocationService locserv;
	
	FlightService flserv;
	
	@Autowired
	AdminDao admindao;
	
	@Autowired
	LocationDao locationdao;
	
	public AdminController(AdminService service, LocationService locservice, FlightService flightservice) {
		super();
		this.adminserv=service;
		this.locserv=locservice;
		this.flserv=flightservice;
	}
/************************************** Admin register/update/login **********************************/
	
	@PostMapping("/addAdmin")// create admin
	public ResponseEntity<Admin> Admin(@RequestBody Admin admin){
		Admin ad = adminserv.addAdmin(admin);
		return new ResponseEntity<>(ad, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateAdmin/{id}")// update admin
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Integer adminid, @RequestBody Admin ad){
		Admin admin = adminserv.findAdminbyID(adminid);
		if(admin != null) {
			admin.setAdminname(ad.getAdminname());
			admin.setAdminpassword(ad.getAdminpassword());
			admindao.save(admin);
			return new ResponseEntity<>(admin,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	
	@PostMapping("/adminLogin")// admin login
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin ad){
		Admin admin = adminserv.showAdminUsingLogin(ad.getAdminemail(),ad.getAdminpassword());
		return ResponseEntity.ok(admin);
	}
/************************************* Admin Operations( adding flight, location etc) *****************************************/	
  
	
	@PostMapping("/addFlight/{locid1}/{locid2}")
	public ResponseEntity<Flight> createFlight(@RequestBody Flight flight,
			@PathVariable("locid1") Integer locId1,
			@PathVariable("locid2") Integer locId2){
		Flight tempflight= flight;
		tempflight.setFlightsource(locserv.findLocationbyID(locId1));
		tempflight.setFlightdestination(locserv.findLocationbyID(locId2));
		
		flserv.addFlight(tempflight);
		
		return new ResponseEntity<>(tempflight, HttpStatus.CREATED);
		
		
	}
	
	
	@PostMapping("/addLoc")
	public ResponseEntity<Location> createLocation(@RequestBody Location location){
		
		locserv.addLocation(location);
		return new ResponseEntity<>(location, HttpStatus.CREATED);

		
	}
	
	@GetMapping("/getLocations")
	public ResponseEntity<List<Location>> getlocations(){
		List<Location> details = locserv.findAllLocations();
		return ResponseEntity.ok().body(details);
	}

	
}