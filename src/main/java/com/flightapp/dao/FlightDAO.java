package com.flightapp.dao;

import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;

public interface FlightDAO {
	public String scheduleFlight(int availableSeats, Flight flight, Schedule scedule);
}
