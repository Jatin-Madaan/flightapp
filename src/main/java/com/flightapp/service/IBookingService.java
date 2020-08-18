package com.flightapp.service;
import com.flightapp.entities.Passenger;
import com.flightapp.exception.BookingException;

public interface IBookingService 
{
	public Passenger addPassenger(Passenger passenger) throws BookingException;
}
