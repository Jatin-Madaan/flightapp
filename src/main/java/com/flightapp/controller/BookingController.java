package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Booking;
import com.flightapp.service.IBookingService;

@RestController
public class BookingController 
{
	@Autowired
	IBookingService bookingService;
	
	@PostMapping("/addBooking")  
	private int saveBook(@RequestBody Booking booking)   
	{  
		bookingService.addBooking(booking);  
		return booking.getBookingId();  
	}  
}
