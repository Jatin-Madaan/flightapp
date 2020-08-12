package com.flightapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightapp.entities.Flight;

@Service
public interface IAddFlightService {

	public Flight save(Flight flight);

	public List<Flight> fetchAll();

	public Flight fetchByFlightId(int flightId);

	public String deleteById(int flightId);
}
