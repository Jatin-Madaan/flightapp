package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Airport;

public interface IAirportService {
	public List<Airport> getAllAirports() throws Exception;
	public Airport getAirportById(int airportId) throws Exception;
	public Airport addAirport(Airport airport) throws Exception;
}
