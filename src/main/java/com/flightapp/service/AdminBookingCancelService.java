package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightapp.dao.IBookingDAO;
import com.flightapp.entities.Booking;

public class AdminBookingCancelService implements IAdminBookingCancelService
{
	@Autowired
	IBookingDAO booking;
	
	@Override
	public List<Booking> viewAllBookings() 
	{
		return booking.findAll();
	}
	
	@Override
	public String cancelBookingById(int bookingId) 
	{
		if(booking.existsById(bookingId))
		{
			booking.deleteById(bookingId);
			return "Cancelled Successfully";
		}
		else
		{
			return "Cancellation not done";
		}
	}
}
