package com.Airbus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;
import java.util.List;
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
	
	@Autowired
	UserDao userdao;
	

	
	public BookingController( FlightService flightservice) {
		super();
		
		this.flserv=flightservice;
	}
	@Transactional
	public void transact(Passengers p, Flight f, Ticket temp) {
		
		passdao.save(p);
		Ticket actualTicket = getLastElement(p.getTickets());
		//f.addPassenger(p);
		f.addTicket(actualTicket);
	    flightdao.save(f);
	}
	
	private static <T> T getLastElement(Set<T> set) {
        // Convert the Set to an array and get the last element
        return set.isEmpty() ? null : set.toArray((T[]) new Object[0])[set.size() - 1];
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
				actualPass.addTicket(temp);
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
	
	@DeleteMapping("/delete/{ticketid}")//cancel ticket
	public ResponseEntity<Ticket> deletePassenger(@PathVariable("ticketid") Integer ticketId){
		
		 
		Ticket ticket=ticketdao.getById(ticketId);
		List<Flight> flights= flightdao.findAll();
		List<Passengers> passengers=passdao.findAll();
	    //Flight junkflight= new Flight();
		for(Flight f: flights) {//get flight
			Set<Ticket> temptickets= f.getTickets();
			for(Ticket t:temptickets) {
				if(t.getTicketId().equals(ticket.getTicketId())) {
					Flight flight= f;
					f.removeTicket(ticket);
					flightdao.save(f);
				    break;
					
				}
				else continue;
			}
		}
		
		for(Passengers p: passengers) {//get flight
			Set<Ticket> temptickets= p.getTickets();
			for(Ticket t:temptickets) {
				if(t.getTicketId().equals(ticket.getTicketId())) {
					Passengers pass= p;
					p.removeTicket(ticket);
					passdao.save(p);
					ticketdao.delete(ticket);
					return new ResponseEntity<>(new Ticket(), HttpStatus.OK);
					
				}
				else continue;
			}
		}
		
		
		return new ResponseEntity<>(new Ticket(), HttpStatus.EXPECTATION_FAILED);
		
           // return new ItemNotFoundException("Employee with id" + id + " is not Found.Pls Give another Id!");

	}
	
	
	///Get Booked seat no from flight
	@GetMapping("/getTickets/{flightid}")
	public ResponseEntity<Set<Ticket>> getTickets(
			@PathVariable("flightid") Integer flightId){
		
		Flight flight= flserv.findFlightbyID(flightId);
		Set<Ticket> tickets= flight.getTickets();
		
		return new ResponseEntity<>(tickets, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/getPasses/{passid}")
	public ResponseEntity<Set<Ticket>> getPasses(
			@PathVariable("passid") Integer passId){
		Passengers actualPass=passdao.getById(passId);
		Set<Ticket> tickets=actualPass.getTickets();
		
		return new ResponseEntity<>(tickets, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getFlight/{ticketid}")
	public ResponseEntity<Flight> getFlight(
			@PathVariable("ticketid") Integer ticketId){
		Ticket ticket=ticketdao.getById(ticketId);
		List<Flight> flights= flightdao.findAll();
	    Flight junkflight= new Flight();
		for(Flight f: flights) {
			Set<Ticket> temptickets= f.getTickets();
			for(Ticket t:temptickets) {
				if(t.getTicketId().equals(ticket.getTicketId())) {
					Flight flight= f;
					return new ResponseEntity<>(flight, HttpStatus.OK);
					
				}
				else continue;
			}
		}
		
		return new ResponseEntity<>(junkflight, HttpStatus.OK);
		
		
	}
	
	
	
	
}
