package com.flightapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.flightapp.entities.Flight;
import com.flightapp.entities.ScheduleFlight;

public interface IGetFlightService {
	
	public List<ScheduleFlight> getFlights(String source, String Destination, LocalDate dept_date, int passengers);

}
