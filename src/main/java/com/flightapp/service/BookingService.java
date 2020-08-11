package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IBookingDAO;
import com.flightapp.entities.Booking;

@Service
public class BookingService implements IAdminBookingCancelService, IBookingService
{
	@Autowired
	IBookingDAO bookingDao;
	
	@Override
	public Booking addBooking(Booking booking) 
	{
		return bookingDao.save(booking);
	}
	
	@Override
	public List<Booking> viewAllBookings() 
	{
		return bookingDao.findAll();
	}
	
	@Override
	public String cancelBookingById(int bookingId) 
	{
		if(bookingDao.existsById(bookingId))
		{
			bookingDao.deleteById(bookingId);
			return "Cancelled Successfully";
		}
		else
		{
			return "Cancellation not done";
		}
	}
}
