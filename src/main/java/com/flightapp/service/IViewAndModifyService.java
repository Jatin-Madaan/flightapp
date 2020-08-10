package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;

public interface IViewAndModifyService {
	
	public List<Booking> viewBookings(Integer userId);
	public int cancelBooking(int bookingId);
	public int modifyBooking(int bookingId,Schedule schedule);

}
