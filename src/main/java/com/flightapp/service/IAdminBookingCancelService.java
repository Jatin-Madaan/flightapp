package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Booking;
import com.flightapp.exception.BookingException;

public interface IAdminBookingCancelService 
{
	public List<Booking> viewAllBookings() throws Exception;
	public String cancelBookingById(int bookingId);	
}
