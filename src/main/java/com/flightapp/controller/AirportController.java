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
import com.flightapp.entities.Schedule;
import com.flightapp.exception.AirportException;
import com.flightapp.service.IAirportService;

/**
 * @author Jatin
 *
 */
@ControllerAdvice
@RestController
@CrossOrigin(origins = "*")
public class AirportController {
	
	@Autowired
	IAirportService airportService;
	
	/**
	 * Method: getAirportById
	 * Description: get an Airport object by providing id
	 * @param airportId
	 * @return Airport
	 */
	@RequestMapping(value = "/airports/id/{airportId}")
	public Airport getAirportById(@PathVariable int airportId) throws AirportException {
		return airportService.getAirportById(airportId);
	}
	
	/**
	 * Method: getAllAirports
	 * Description: get list of available airports
	 * @return List<Airport>
	 */
	@RequestMapping(value = "/airports/all")
	public List<Airport> getAllAirports() throws AirportException {
		return airportService.getAllAirports();
	}
	
	/**
	 * Method: addAirport
	 * Description: for adding airport object in table
	 * @return Airport
	 */
	@RequestMapping(method = RequestMethod.POST , value = "/airports/add")
	public Airport addAirport( @RequestBody Airport airport) throws AirportException {
		return airportService.addAirport(airport);
	}
}
