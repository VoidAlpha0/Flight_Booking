package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.Location;

@Repository
public interface LocationDao extends JpaRepository<Location, Integer>{
}