package com.Airbus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(generator = "ticketgen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ticketgen", sequenceName = "ticket_seq",initialValue = 1,allocationSize = 1)
	private Integer ticketId;
	
	
	
	@OneToOne(mappedBy = "ticket")
	private Passengers passenger;
	
	private String seatno;
	//private String userId;

}
