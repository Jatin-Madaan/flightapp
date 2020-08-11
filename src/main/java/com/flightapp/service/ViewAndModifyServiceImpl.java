package com.flightapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightapp.dao.IBookingDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;

@Service
public class ViewAndModifyServiceImpl implements IViewAndModifyService {
	
	@Autowired
	private IBookingDAO dao;

	@Override
	public List<Booking> viewBookings(Integer userId) {
		List<Booking> booking=dao.findAll();
		booking=booking.stream().filter(e->e.getUser().getUserId()==userId).collect(Collectors.toList());
		return booking;
	}

	@Override
	public Booking cancelBooking(int bookingId) {
		Booking booking=dao.getOne(bookingId);
		booking.setBookingStatus("Cancelled");
		booking.getScheduleFlight().setAvailableSeats(booking.getScheduleFlight().getAvailableSeats()+1);
		return dao.save(booking);
	}

	@Override
	public Booking modifyBooking(int bookingId, Schedule schedule) {
		Booking booking=dao.getOne(bookingId);
		booking.getScheduleFlight().setSchedule(schedule);
		return dao.save(booking);
	}
}
