package com.flightapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ScheduleFlight implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public ScheduleFlight() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="SCHEDULEFLIGHT_ID")
	private int scheduleFlightId;
	
	private int availableSeats;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name="FLIGHT_ID")
	private Flight flight;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "SCHEDULE_ID")
	private Schedule schedule;
	
	@OneToMany(mappedBy = "scheduleFlight", cascade = CascadeType.REFRESH)
	@JsonIgnore
	private Set<Booking> bookings = new HashSet<Booking>();

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public void setScheduleFlightId(int scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}

	public int getScheduleFlightId() {
		return scheduleFlightId;
	}
	
	
	
}
