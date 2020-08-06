package com.flightapp.dao;

import java.util.List;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;

public interface FlightDAO {
	public String scheduleFlight(int availableSeats, Flight flight, Schedule scedule);
	
	public List<Booking> viewBookings(String userId);
	
	public int cancelBooking(String bookingId);
	
	public int modifyBooking(String bookingId,Schedule schedule);
}
