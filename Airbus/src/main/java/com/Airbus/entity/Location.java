package com.Airbus.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(generator = "locationgen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "locationgen", sequenceName = "location_seq",initialValue = 1 ,allocationSize = 1)
	private Integer locId;
	@Column(nullable = false)
	private String terminal;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String country;
	
	@OneToMany(mappedBy = "flightsource")
	private Set<Flight> Flightsrc=new HashSet<Flight>();
	
	@OneToMany(mappedBy = "flightdestination")
	private Set<Flight> Flightdst=new HashSet<Flight>();
	
	public Integer getLocId() {
		return locId;
	}
	public void setLocId(Integer locId) {
		this.locId = locId;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
