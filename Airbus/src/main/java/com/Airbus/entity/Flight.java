package com.Airbus.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;
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
	
	private String departureDate;
	
	private String departureTime;
	
	private String arrivalDate;
	
	private String arrivalTime;
	
	private Integer price; 
	
	
	/******************************JOINS*************************************/
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="flight_tickets", joinColumns= {@JoinColumn(name="flightId")}, inverseJoinColumns= {@JoinColumn(name="ticketId")})
	private Set<Ticket>tickets=new LinkedHashSet<Ticket>();

	/**************************GETTERS AND SETTERS***************************/
	
	
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
		}
	
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void removeTicket(Ticket ticket) {
		this.tickets.remove(ticket);
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
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
