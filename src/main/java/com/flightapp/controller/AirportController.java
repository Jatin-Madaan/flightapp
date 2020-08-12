package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Airport;
import com.flightapp.service.IAirportService;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "*")
public class AirportController {
	
	@Autowired
	IAirportService airportService;
	
	@RequestMapping(value = "/airports/id/{airportId}")
	public Airport getAirportById(@PathVariable int airportId) throws Exception {
		return airportService.getAirportById(airportId);
	}
	
	@RequestMapping(value = "/airports/all")
	public List<Airport> getAllAirports() throws Exception {
		return airportService.getAllAirports();
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/airports/add")
	public Airport addAirport( @RequestBody Airport airport) throws Exception {
		return airportService.addAirport(airport);
	}
}
