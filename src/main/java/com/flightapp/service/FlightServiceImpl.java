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

	public String addFlight(Flight flight) {
		return dao.addFlight(flight);}

	
	public String modifySchedule(Schedule schedule)
	{
		return dao.modifySchedule(schedule);
	}

	public Booking getbookingbyid(String bookingid, String userid){
		Booking bookingdetails = dao.getbookingbyid(bookingid);
		if(bookingdetails.getUser().getUserId().contentEquals(userid)) {	
			System.out.println(bookingdetails.getUser().getUserId());
			return bookingdetails;
		}
		else {
			return null;
		}
	}
	
	public String getBookingByIdAdmin(String bookingId)
	{
		return dao.getBookingByIdAdmin(bookingId);
	}
	
	public String getBookingByFlightAdmin(String flightId)
	{
		return dao.getBookingByFlightAdmin(flightId);
	}
	
	public int setbookingstatusbyid(String bookingid, String status) {
		Booking bookingdetails = dao.setbookingstatusbyid(bookingid);
		String status_before = bookingdetails.getBookingStatus();
		if(status_before.equals("Failed")) {
			return -1;
		}
		if(status_before.contentEquals(status)) {
			return 0;
		}
		else {
			bookingdetails.setBookingStatus(status);
			return 1;
		}
		
	}


	public List<Booking> viewBookings(String userId){
		return dao.viewBookings(userId);
	}
	
	public int cancelBooking(String bookingId) {
		return dao.cancelBooking(bookingId);
	}
	
	public int modifyBooking(String bookingId,Schedule schedule) 
	{
		return dao.modifyBooking(bookingId, schedule);

	}
}
