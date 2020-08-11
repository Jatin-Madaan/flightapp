package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;

public interface IViewAndModifyService {
	
	public List<Booking> viewBookings(int userId);
	public Booking cancelBooking(int bookingId);
	public Booking modifyBooking(int bookingId,Schedule schedule);

}
