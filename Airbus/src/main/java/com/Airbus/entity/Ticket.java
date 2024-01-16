package com.Airbus.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Ticket {
	
	@Id
	@GeneratedValue(generator = "ticketgen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ticketgen", sequenceName = "ticket_seq",initialValue = 1,allocationSize = 1)
	private Integer ticketId;
	
	@Column(nullable = false)
	private String passname;
	private String passDOB;
	private String seatno;
	//private String userId;

}
