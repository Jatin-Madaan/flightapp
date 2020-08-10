package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flightapp.entities.Booking;
import com.flightapp.service.IAdminBookingCancelService;

public class AdminController 
{
	@Autowired
	IAdminBookingCancelService bookingCancelService;
	
	@GetMapping("/viewAllBooking")  
	private List<Booking> getAllBooks()   
	{  
	return bookingCancelService.viewAllBookings();  
	}  
	
	@DeleteMapping("/booking/{bookingId}")  
	private void deleteBook(@PathVariable("bookingId") int bookingId)   
	{  
	bookingCancelService.cancelBookingById(bookingId);  
	}  
}
