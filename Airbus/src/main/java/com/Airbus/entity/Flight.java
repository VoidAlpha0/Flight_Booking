package com.Airbus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(generator = "flightgen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "flightgen", sequenceName = "flight_seq",initialValue = 1,allocationSize = 1)
	private Integer flightId;
	private String flightsource;
	private String flightdestination;
	private String flightdate;
	
	
	
	public String getFlightdate() {
		return flightdate;
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
	public String getFlightsource() {
		return flightsource;
	}
	public void setFlightsource(String flightsource) {
		this.flightsource = flightsource;
	}
	public String getFlightdestination() {
		return flightdestination;
	}
	public void setFlightdestination(String flightdestination) {
		this.flightdestination = flightdestination;
	}
	
	
	
}
