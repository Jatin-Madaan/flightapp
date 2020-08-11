package com.flightapp.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.flightapp.entities.Flight;

public interface IGetFlightService {
	
	public List<Flight> getFlights(String source, String Destination, LocalDateTime time);

}
