package com.flightapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Passenger;
import com.flightapp.entities.ScheduleFlight;
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
	
	@GetMapping("/getFlightById/{scheduleFlightId}")
	public List<ScheduleFlight> getScheduleFlightById(@PathVariable int scheduleFlightId)
	{
		
		ScheduleFlight scheduleFlight = bookingService.getScheduleFlightById(scheduleFlightId);
		List<ScheduleFlight> sc = new ArrayList<ScheduleFlight>();
		sc.add(scheduleFlight);
		return sc;
	}
	
	@PostMapping("/addBooking")
	public int addBooking(@RequestBody Booking booking)
	{
		return bookingService.addBooking(booking);
	}
}
