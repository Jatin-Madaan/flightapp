package com.flightapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class ScheduleFlight implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public ScheduleFlight() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="SCHEDULEFLIGHT_ID")
	private int ScheduleFlight;
	
	private int availableSeats;
	
	private Flight flight;
	
	private Schedule schedule;

	public int getScheduleFlight() {
		return ScheduleFlight;
	}

	public void setScheduleFlight(int scheduleFlight) {
		ScheduleFlight = scheduleFlight;
	}

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
	
	
	
}
