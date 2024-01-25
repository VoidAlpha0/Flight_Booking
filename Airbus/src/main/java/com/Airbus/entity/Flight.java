package com.Airbus.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(generator = "flightgen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "flightgen", sequenceName = "flight_seq",initialValue = 1,allocationSize = 1)
	private Integer flightId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="flight_source_linked", joinColumns= {@JoinColumn(name="flightId")}, inverseJoinColumns= {@JoinColumn(name="locId")})
	private Location flightsource;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="flight_destination_linked", joinColumns= {@JoinColumn(name="flightId")}, inverseJoinColumns= {@JoinColumn(name="locId")})
	private Location flightdestination;
	
	private String flightdate;
	
	/******************************JOINS*************************************/
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="flight_passengers", joinColumns= {@JoinColumn(name="flightId")}, inverseJoinColumns= {@JoinColumn(name="passId")})
	private Set<Passengers>passengers=new HashSet<Passengers>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="flight_tickets", joinColumns= {@JoinColumn(name="flightId")}, inverseJoinColumns= {@JoinColumn(name="ticketId")})
	private Set<Ticket>tickets=new HashSet<Ticket>();

	/**************************GETTERS AND SETTERS***************************/
	
	public String getFlightdate() {
		return flightdate;
	}
	public Set<Passengers> getPassengers() {
		return passengers;
	}
	public void setPassengers(Set<Passengers> passengers) {
		this.passengers = passengers;
	}
	
	public void addPassenger(Passengers passenger) {
		this.passengers.add(passenger);
		}
	
	public void removePassenger(Passengers passenger) {
		this.passengers.remove(passenger);
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
		}
	
	public void removeTicket(Ticket ticket) {
		this.tickets.remove(ticket);
	}
	
	public void setFlightdate(String flightdate) {
		this.flightdate = flightdate;
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Location getFlightsource() {
		return flightsource;
	}
	public void setFlightsource(Location flightsource) {
		this.flightsource = flightsource;
	}
	public Location getFlightdestination() {
		return flightdestination;
	}
	public void setFlightdestination(Location flightdestination) {
		this.flightdestination = flightdestination;
	}
	
	
	
}
