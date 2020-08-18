package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Passenger;
import com.flightapp.service.IBookingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController 
{
	@Autowired
	IBookingService bookingService;
		
	@PostMapping("/addPassenger")
	public String addPassengerDetails(@RequestBody Passenger passenger) throws Exception 
	{
		try 
		{
			bookingService.addPassenger(passenger);
			return "Passenger details has been added.";
		} 
		catch (DataIntegrityViolationException ex) 
		{
			throw new Exception(" Booking Already Exists!");
		}
	}
}
