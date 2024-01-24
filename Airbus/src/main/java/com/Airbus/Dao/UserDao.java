package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	@Query("SELECT a FROM User a WHERE a.useremail = :useremail")
	User findByuname(@Param("useremail") String useremail);	
	public User findByUseremailAndUserpassword(String email, String password);
	
}