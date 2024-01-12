package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.BookingDetails;

@Repository
public interface BookingDetailsDao extends JpaRepository<BookingDetails, Integer> {

}
