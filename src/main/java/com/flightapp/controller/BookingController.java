package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public String addBooking(@RequestBody Booking booking) throws Exception 
	{
		try 
		{
			bookingService.addBooking(booking);
			return "You're Registered! Tap on login to go further.";
		} 
		catch (DataIntegrityViolationException ex) 
		{
			throw new Exception(" Booking Already Exists!");
		}
	}
}
