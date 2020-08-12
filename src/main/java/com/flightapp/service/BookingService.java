package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IBookingDAO;
import com.flightapp.entities.Booking;
import com.flightapp.exception.BookingException;

@Service
public class BookingService implements IAdminBookingCancelService, IBookingService
{
	@Autowired
	IBookingDAO bookingDao;
	
	@Override
	public Booking addBooking(Booking booking) throws Exception
	{
		return bookingDao.save(booking);
	}
	
	@Override
	public List<Booking> viewAllBookings() 
	{
		
		return bookingDao.findAll();
	}
	
	@Override
	public String cancelBookingById(int bookingId) throws BookingException 
	{
		if(bookingDao.existsById(bookingId))
		{
			bookingDao.deleteById(bookingId);
			return "Cancelled succesfully!";
		}
		else
		{
			throw new BookingException("Error: Cancelling the data which is not present!");
		}
	}
}
