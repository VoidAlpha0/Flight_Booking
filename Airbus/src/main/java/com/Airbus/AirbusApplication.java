package com.Airbus;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Airbus.entity.Admin;
import com.Airbus.serviceImpl.AdminServiceImpl;

@SpringBootApplication
public class AirbusApplication {
	
	@Autowired
	AdminServiceImpl adminService;
	


	public static void main(String[] args) {
		SpringApplication.run(AirbusApplication.class, args);
		System.out.println("Started!!!!");
	}

}
