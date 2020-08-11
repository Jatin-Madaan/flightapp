package com.flightapp.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;

@Repository
public interface FlightDAO {

	public String scheduleFlight(int availableSeats, Flight flight, Schedule scedule);

	public String addFlight(Flight flight);
	
	public List<Flight> getFlights(String src, String dest);	

	public Booking getbookingbyid(int bookingid);
	
	public String getBookingByFlightAdmin(String flightId);
	
	public String getBookingByIdAdmin(Integer bookingId);
	
	public Booking setbookingstatusbyid(int bookingid);

	public List<Booking> viewBookings(Integer userId);
	
	public int cancelBooking(String bookingId);
	
	public int modifyBooking(String bookingId,Schedule schedule);
	
	public String modifySchedule(Schedule schedule);


}
