package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	@Query("SELECT a FROM Admin a WHERE a.adminname = :adminname")
	Admin findByAdminUName(@Param("adminname") String adminname);

}