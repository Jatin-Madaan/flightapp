package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Airport;
import com.flightapp.exception.AirportException;

public interface IAirportService {
	public List<Airport> getAllAirports() throws AirportException;
	public Airport getAirportById(int airportId) throws AirportException;
	public Airport addAirport(Airport airport) throws AirportException;
}
