package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Airbus.entity.Ticket;


public interface TicketDao extends JpaRepository<Ticket, Integer> {

}
