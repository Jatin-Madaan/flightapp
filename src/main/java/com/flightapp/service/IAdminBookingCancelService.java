package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Booking;

public interface IAdminBookingCancelService 
{
	public List<Booking> viewAllBookings();
	public String cancelBookingById(int bookingId);
}
