package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Flight;

public interface IAddFlightService {
	
	public Flight save(Flight flight);

	public List<Flight> fetchAll();

	public Flight fetchByFlightId(int flightId);

	public void deleteById(int flightId);
}
