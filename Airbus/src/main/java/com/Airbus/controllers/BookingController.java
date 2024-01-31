package com.Airbus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;
import java.util.Optional;
import com.Airbus.Dao.*;
import javax.transaction.Transactional;
import com.Airbus.entity.User;
import com.Airbus.entity.Passengers;
import com.Airbus.entity.Ticket;
import com.Airbus.entity.Flight;
import com.Airbus.entity.TicketGenerationRequest;
import com.Airbus.services.AdminService;
import com.Airbus.services.FlightService;
import com.Airbus.services.LocationService;

@RestController
@RequestMapping("/Booking")
public class BookingController {

FlightService flserv;
	
	@Autowired
	PassengerDao passdao;
	
	@Autowired
	FlightDao flightdao;
	
	@Autowired
	TicketDao ticketdao;
	

	
	public BookingController( FlightService flightservice) {
		super();
		
		this.flserv=flightservice;
	}
	@Transactional
	public void transact(Passengers p, Flight f, Ticket temp) {
		passdao.save(p);
		Ticket actualTicket= p.getTicket();
		f.addPassenger(p);
		f.addTicket(actualTicket);
	    flightdao.save(f);
	}
	
	//Book the ticket
	@PostMapping("/ticketgen/{flightid}")
	public ResponseEntity<Flight> ticketGen(@RequestBody TicketGenerationRequest request, 
			@PathVariable("flightid") Integer flightId){
		
		Set<Optional<Passengers>> passengers = request.getPassengers();
	    Set<Optional<Ticket>> tempseats = request.getTempseats();
		
		Flight flight= flserv.findFlightbyID(flightId);
		int count=0;
		for (Optional<Passengers> passenger: passengers ) {
			
			Passengers pass= passenger.get();
			Integer passId= pass.getPassId();
			System.out.println(passId);
			Passengers actualPass=passdao.getById(passId);
			//flight.addPassenger(actualPass);
			
			for(Optional<Ticket> t: tempseats) {
				Ticket temp= t.get();
				actualPass.setTicket(temp);
																//flight.addTicket(temp);
				transact(actualPass,flight,temp);
																//passdao.save(actualPass);
																//flightdao.save(flight);
				tempseats.remove(t);
				break;
			}
		}
		
		
		 return new ResponseEntity<>(flight, HttpStatus.OK);
		
	}
	
	
	///Get Booked seat no from flight
	@GetMapping("/getTickets/{flightid}")
	public ResponseEntity<Set<Ticket>> getTickets(
			@PathVariable("flightid") Integer flightId){
		
		Flight flight= flserv.findFlightbyID(flightId);
		Set<Ticket> tickets= flight.getTickets();
		
		return new ResponseEntity<>(tickets, HttpStatus.OK);
		
		
	}
	
}
