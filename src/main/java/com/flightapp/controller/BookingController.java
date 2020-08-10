package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flightapp.entities.Booking;
import com.flightapp.service.UserService;

public class BookingController 
{
	@Autowired
	UserService userService;
	
	@PostMapping("/addBooking")  
	private int saveBook(@RequestBody Booking booking)   
	{  
		userService.addBooking(booking);  
		return booking.getBookingId();  
	}  
}
