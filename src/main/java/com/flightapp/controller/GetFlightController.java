package com.flightapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Flight;
import com.flightapp.service.IGetFlightService;

@RestController
@RequestMapping("/flight")
public class GetFlightController {
	
	@Autowired
	private IGetFlightService getFlightService;
	
	Logger logger = LoggerFactory.getLogger(GetFlightController.class);
	
	/**
	 * Method: getFlights
	 * Description: Used to fetch all the flights between Given source and destination.
	 * @param source: Source airport location
	 * @param destination: Destination airport location
	 * @param searchDate: Date, for which user want to search flights
	 * @return List: It returns the list of scheduled flights
	 * @author Adithya 
	 */
	@GetMapping("/getFlights/{source}/{destination}")
	public List<Flight> getFlights(@PathVariable String source, @PathVariable String destination) {
		LocalDateTime time = LocalDateTime.now();
		logger.info("Searching flights between "+source+" - "+destination);
		return getFlightService.getFlights(source,destination,time);
	}
}

