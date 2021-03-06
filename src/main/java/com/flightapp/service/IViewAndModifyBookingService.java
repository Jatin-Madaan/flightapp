package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;

public interface IViewAndModifyBookingService {
	
	//methods for viewing and modifying user bookings by customer
	
	public List<Booking> viewBookings(int userId);
	public Booking cancelBooking(int bookingId);

}
