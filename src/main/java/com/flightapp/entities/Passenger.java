package com.flightapp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PASSENGER_MASTER")
public class Passenger implements Serializable {

	private static final long serialVersionUID = 1L;

	public Passenger() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	private int pnrNumber;

	private String passengerName;
	
	private int age;
	
	private String luggage;
	
	private String seatNumber;
	
	private String travelClass;
	
	@ManyToOne
	@JoinColumn(name="BOOKING_ID")
	private Booking booking;

	public int getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLuggage() {
		return luggage;
	}

	public void setLuggage(String luggage) {
		this.luggage = luggage;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	@JsonIgnore
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
}
