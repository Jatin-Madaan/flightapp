package com.flightapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;

@Repository
public interface IBookingDAO extends JpaRepository<Booking, Integer>{
	
	public List<Booking> viewBookings(Integer userId);
	
	public int cancelBooking(String bookingId);
	
	public int modifyBooking(String bookingId,Schedule schedule);

}
