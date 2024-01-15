package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer>{
}