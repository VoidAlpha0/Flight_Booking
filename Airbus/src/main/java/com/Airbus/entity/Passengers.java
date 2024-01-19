package com.Airbus.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;

@Entity
public class Passengers {
	@Id
	@GeneratedValue(generator = "passengergen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "passengergen", sequenceName = "passenger_seq",initialValue = 1,allocationSize = 1)
	private Integer passId;
	@Column(nullable = false)
	private String passname;
	private String passDOB;
	//private String userId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket", referencedColumnName = "ticketId")
	private Ticket ticket;
	
	
	public Integer getPassId() {
		return passId;
	}
	public void setPassId(Integer passId) {
		this.passId = passId;
	}
	public String getPassname() {
		return passname;
	}
	public void setPassname(String passname) {
		this.passname = passname;
	}
	public String getPassDOB() {
		return passDOB;
	}
	public void setPassDOB(String passDOB) {
		this.passDOB = passDOB;
	}
	
	
	
	
}
