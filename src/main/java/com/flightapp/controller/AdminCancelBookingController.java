package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Booking;
import com.flightapp.service.IAdminBookingCancelService;

@RestController
public class AdminCancelBookingController 
{
	@Autowired
	IAdminBookingCancelService bookingCancelService;
	
	@GetMapping("/viewAllBooking")  
	private List<Booking> getAllBooking()   
	{  
		return bookingCancelService.viewAllBookings();  
	}  
	
	@DeleteMapping("/booking/{bookingId}")  
	private void deleteBooking(@PathVariable("bookingId") int bookingId)   
	{  
	bookingCancelService.cancelBookingById(bookingId);  
	}  
}
