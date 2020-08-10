package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.FlightDAO;
import com.flightapp.dao.IBookingDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;

@Service
public class ViewAndModifyServiceImpl implements IViewAndModifyService {
	
	@Autowired
	private IBookingDAO dao;

	@Override
	public List<Booking> viewBookings(Integer userId) {
		return dao.viewBookings(userId);
	}

	@Override
	public int cancelBooking(String bookingId) {
		return dao.cancelBooking(bookingId);
	}

	@Override
	public int modifyBooking(String bookingId, Schedule schedule) {
		return dao.modifyBooking(bookingId, schedule);
	}
}
