package com.Airbus.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	public Admin findByAdminemailAndAdminpassword(String email, String password);
	public  Admin   findByAdminemail(String email);
	
		public List<Admin>  findBySeniormangeremail(String seniormangeremail);
		public Admin findByadminid(Long id);
	

}