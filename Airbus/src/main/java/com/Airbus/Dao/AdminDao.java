package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	public Admin findByAdminemailAndAdminpassword(String email, String password);
	public  Admin   findByAdminemail(String email);	
	public Admin findByadminid(Integer adminid);
}