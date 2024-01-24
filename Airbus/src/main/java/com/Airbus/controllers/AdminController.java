package com.Airbus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Airbus.entity.Admin;
import com.Airbus.Dao.AdminDao;
import com.Airbus.services.AdminService;

@RestController

@RequestMapping("/Admin")
public class AdminController {
	AdminService adminserv;
	
	@Autowired
	AdminDao admindao;
	
	public AdminController(AdminService service) {
		super();
		this.adminserv=service;
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> Admin(@RequestBody Admin admin){
		Admin ad = adminserv.addAdmin(admin);
		return new ResponseEntity<>(ad, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateAdmin/{id}")
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
	
	
	@PostMapping("/adminLogin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin ad){
		Admin admin = adminserv.showAdminUsingLogin(ad.getAdminemail(),ad.getAdminpassword());
		return ResponseEntity.ok(admin);
	}
	
	
	
	
}