package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;

public interface IFlightService {
	
	public String scheduleFlight(int availableSeats, Flight flight, Schedule scedule);

	public String addFlight(Flight flight);
	
	public Booking getbookingbyid(int bookingid,int userId);
	
	public String getBookingByFlightAdmin(String flightId);
	
	public String getBookingByIdAdmin(Integer bookingId);
	
	public int setbookingstatusbyid(int bookingid,String status, int securitynumber, int amount);

	public List<Booking> viewBookings(int userId);
	
	public Booking cancelBooking(int bookingId);
	
	public Booking modifyBooking(int bookingId,Schedule schedule);
	
	public String modifySchedule(Schedule schedule);

}
