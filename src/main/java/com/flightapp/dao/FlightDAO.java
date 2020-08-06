package com.flightapp.dao;

import java.util.List;

import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;

public interface FlightDAO {
	
	public List<Flight> getFlights(String src, String dest);
	
	public String scheduleFlight(int availableSeats, Flight flight, Schedule scedule);
}
