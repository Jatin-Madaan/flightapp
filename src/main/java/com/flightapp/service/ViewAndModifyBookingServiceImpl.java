package com.flightapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightapp.dao.IBookingDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.BookingException;

@Service
public class ViewAndModifyBookingServiceImpl implements IViewAndModifyBookingService {
	
	//Injecting dao layer dependency to perform crud operations
	
	@Autowired
	private IBookingDAO bookingDao;
	
	//getting logger object for logging
	
	private Logger logger = Logger.getLogger(getClass());
	
	//service method for viewing bookings
	
	@Override
	public List<Booking> viewBookings(int userId) throws BookingException{
		
		//fetching list of all bookings present in database
		List<Booking> booking=bookingDao.findAll();
		
		//if no bookings are present in database
		if(booking==null) {
			logger.error("Error while fetching bookings..!!");
			throw new BookingException("Error while fetching bookings..!!");
		}
		
		//getting bookings for the current user
		booking=booking.stream().filter(e->e.getUser().getUserId()==userId).collect(Collectors.toList());
		
		//if current user has no bookings
		if(booking.size()==0) {
			logger.error("No bookings found for the given User..!!");
			throw new BookingException("No bookings found..!!");
		}
		
		//successfully returning list of bookings for the user
		logger.info("Returned list of bookings...!!");
		return booking;
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingException{
		
		//fetching the booking from database to cancel
		Booking booking=bookingDao.getOne(bookingId);
		
		//if the booking is not found
		if(booking==null) {
			logger.error("No booking found with given Id..!!");
			throw new BookingException("Error while fetching the booking..!!");
		}
		
		//setting the status after fetching
		booking.setBookingStatus("Cancelled");
		
		//increasing number of seats
		booking.getScheduleFlight().setAvailableSeats(booking.getScheduleFlight().getAvailableSeats()+booking.getNoOfPassenger());
		
		//saving the changes in database
		logger.info("Successfully cancelled the booking..!!");
		return bookingDao.save(booking);
	}

	@Override
	public Booking modifyBooking(int bookingId, Schedule schedule) throws BookingException{

		//fetching the booking from database to modify
		Booking booking=bookingDao.getOne(bookingId);
		
		//if the booking is not found
		if(booking==null) {
			logger.error("No booking found with given Id..!!");
			throw new BookingException("Error while fetching the booking..!!");
		}
		
		//setting the new schedule
		booking.getScheduleFlight().setSchedule(schedule);
		
		//saving changes in database
		logger.info("Successfully modified the booking..!!");
		return bookingDao.save(booking);
	}
}