package com.Airbus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(generator = "ticketgen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ticketgen", sequenceName = "ticket_seq",initialValue = 1,allocationSize = 1)
	private Integer ticketId;
	
	@ManyToOne
    @JoinColumn
    @Transient
    private Passengers passenger;
	
	@ManyToOne
    @JoinColumn
    @Transient
    private Flight flight;
	
	private String seatno;
	//private String userId;
	

	public String getSeatno() {
		return seatno;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Passengers getPassenger() {
		return passenger;
	}

	public void setPassenger(Passengers passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

}
