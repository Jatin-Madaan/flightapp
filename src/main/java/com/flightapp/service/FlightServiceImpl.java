package com.flightapp.service;

import java.util.List;

import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;

public class FlightServiceImpl {

	private FlightDAO dao;
	
	public FlightServiceImpl(FlightDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	public List<Flight> getFlights(String src, String dest)
	{
		return dao.getFlights(src, dest);
	}
	
	public String scheduleFlight(int availableSeats, Flight flight, Schedule schedule) {
		return dao.scheduleFlight(availableSeats, flight, schedule);
	}
	
	public List<Booking> viewBookings(String userId){
		return dao.viewBookings(userId);
	}
	
	public int cancelBooking(String bookingId) {
		return dao.cancelBooking(bookingId);
	}
	
	public int modifyBooking(String bookingId,Schedule schedule) {
		return dao.modifyBooking(bookingId, schedule);
	}
}