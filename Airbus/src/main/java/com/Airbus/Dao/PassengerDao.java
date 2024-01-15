package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.Passengers;

@Repository
public interface PassengerDao extends JpaRepository<Passengers, Integer> {

}
