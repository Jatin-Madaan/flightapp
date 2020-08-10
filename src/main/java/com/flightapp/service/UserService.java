package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightapp.dao.IBookingDAO;
import com.flightapp.entities.Booking;

public class UserService implements UserServiceInterface
{
	@Autowired
	IBookingDAO bookingDao;
	
	@Override
	public void addBooking(Booking booking) 
	{
		bookingDao.save(booking);
	}
}
