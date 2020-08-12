package com.flightapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger LOGGER = LoggerFactory.getLogger(BookingService.class);
	
	
	/** Method: viewAllBookings
	 * Description: get all the booking details.
	 * @return Booking object: It returns all the data present in Booking database
 	 * @author Maneesh Kumar
	 */
	@Override
	public List<Booking> viewAllBookings() 
	{
		LOGGER.info("Retrieving data from the database...");
		return bookingDao.findAll();
	}
	
	
	/** Method: addBooking
	 * Description: add the booking details.
	 * @param booking: all the details of the booking.
	 * @return Booking object: It returns an object of new data in booking table
	 * @author Maneesh Kumar
	 */
	@Override
	public Booking addBooking(Booking booking) throws BookingException
	{
		LOGGER.info("Saving new Booking...");
		return bookingDao.save(booking);
	}
	
	
	
	/** Method: cancelBookingById
	 * Description: cancel the booking details.
	 * @param bookingid: BookingId of the booking
	 * @return string: It returns a string which tell whether the booking is cancelled or not.
	 * @author Maneesh Kumar
	 */
	@Override
	public String cancelBookingById(int bookingId)  
	{
		LOGGER.info("Finding the booking...");
		if(bookingDao.existsById(bookingId))
		{
			LOGGER.info("Deleting the booking...");
			bookingDao.deleteById(bookingId);
			return "Cancelled succesfully!";
		}
		else
		{
			LOGGER.error("Error: Cancelling the data which is not present!");
			return "Error: Cancelling the data which is not present!";
		}
	}
}
