package com.flightapp.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="FLIGHT_MASTER")
public class Flight {
	
	

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="FLIGHT_ID")
	@GeneratedValue
	private int flightId;
	
	private String carrierName;
	
	private String flightModel;
	
	private int seatCapacity;
	
	public Flight(int flightId, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightId = flightId;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}


	@OneToMany(mappedBy="flight",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Booking> bookings = new HashSet<>();
	
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", carrierName=" + carrierName + ", flightModel=" + flightModel
				+ ", seatCapacity=" + seatCapacity + "]";
	}

	@OneToMany(mappedBy="flight",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<ScheduleFlight> ScheduleFlights = new HashSet<>();
	
	@JsonIgnore
	public Set<ScheduleFlight> getScheduleFlights() {
		return ScheduleFlights;
	}

	public void setScheduleFlights(Set<ScheduleFlight> scheduleFlights) {
		ScheduleFlights = scheduleFlights;
	}

	@JsonIgnore
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	
	
}
