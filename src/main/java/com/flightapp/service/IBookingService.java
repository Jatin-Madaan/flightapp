package com.flightapp.service;
import java.util.List;

import com.flightapp.entities.Passenger;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.BookingException;

public interface IBookingService 
{
	public Passenger addPassenger(Passenger passenger) throws BookingException;
	public ScheduleFlight getScheduleFlightById(int scheduleFlightId);
}
