package com.Airbus.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="passenger_tickets", joinColumns= {@JoinColumn(name="passId")}, inverseJoinColumns= {@JoinColumn(name="ticketId")})
	private Set<Ticket>tickets=new LinkedHashSet<Ticket>();
	
	@ManyToOne
    @JoinColumn
    @Transient
    private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	
	
	
}
