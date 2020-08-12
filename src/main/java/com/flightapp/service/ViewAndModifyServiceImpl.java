package com.flightapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightapp.dao.IBookingDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.BookingNotExistsException;

@Service
public class ViewAndModifyServiceImpl implements IViewAndModifyService {
	
	@Autowired
	private IBookingDAO dao;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public List<Booking> viewBookings(int userId) throws BookingNotExistsException{
		List<Booking> booking=dao.findAll();
		
		if(booking==null) {
			logger.error("Error while fetching bookings..!!");
			throw new BookingNotExistsException("Error while fetching bookings..!!");
		}
		
		booking=booking.stream().filter(e->e.getUser().getUserId()==userId).collect(Collectors.toList());
		
		if(booking.size()==0) {
			logger.error("No bookings found for the given User..!!");
			throw new BookingNotExistsException("No bookings found..!!");
		}
		
		logger.info("Returned list of bookings...!!");
		return booking;
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotExistsException{
		Booking booking=null;
		booking=dao.getOne(bookingId);
		
		if(booking==null) {
			logger.error("No booking found with given Id..!!");
			throw new BookingNotExistsException("Error while fetching the booking..!!");
		}
		
		booking.setBookingStatus("Cancelled");
		booking.getScheduleFlight().setAvailableSeats(booking.getScheduleFlight().getAvailableSeats()+1);
		logger.info("Successfully cancelled the booking..!!");
		return dao.save(booking);
	}

	@Override
	public Booking modifyBooking(int bookingId, Schedule schedule) throws BookingNotExistsException{
		Booking booking=null;
		booking=dao.getOne(bookingId);
		
		if(booking==null) {
			logger.error("No booking found with given Id..!!");
			throw new BookingNotExistsException("Error while fetching the booking..!!");
		}
		
		booking.getScheduleFlight().setSchedule(schedule);
		logger.info("Successfully modified the booking..!!");
		return dao.save(booking);
	}
}