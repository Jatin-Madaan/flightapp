package com.flightapp.entities;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BOOKING_MASTER")
public class Booking implements Serializable {

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="BOOKING_ID")
	private String bookingId;
	
	private Date bookingDate;
	
	private Time bookingTime;
	
	private Long ticketPrice;
	
	private Long noOfPassenger;
	
	private String bookingStatus;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="FLIGHT_ID")
	private Flight flight;
	
	private ScheduleFlight scheduleFlight;

	@OneToMany(mappedBy="booking",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Passenger> passengers = new HashSet<>();
	
	
	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Time getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Long getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Long getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(Long noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@JsonIgnore
	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@JsonIgnore
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public ScheduleFlight getScheduleFlight() {
		return scheduleFlight;
	}

	public void setScheduleFlight(ScheduleFlight scheduleFlight) {
		this.scheduleFlight = scheduleFlight;
	}
	
	
	
	
}
