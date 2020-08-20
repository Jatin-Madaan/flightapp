package com.flightapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Flight;
import com.flightapp.exception.NoFlightIdException;

import com.flightapp.service.IAddFlightService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Admin/flights")
public class AddFlightController {

	@Autowired
	IAddFlightService addFlightService;

	@PostMapping(value = "/newFlight")
	public Flight addFlight(@RequestBody Flight flight) {
	return	addFlightService.save(flight);
		
	}

	@GetMapping(value = "/getFlights")
	public List<Flight> fetchAll() {

		return addFlightService.fetchAll();
	}

	@GetMapping(value = "/getFlights/{flightId}")
	public Flight fetchByFlightId(@PathVariable int flightId) throws NoFlightIdException {
		return addFlightService.fetchByFlightId(flightId);

	}

	@PutMapping(value = "/updateFlight/{flightId}")
	public String updateFlight(@PathVariable int flightId, @RequestBody Flight flight) throws NoFlightIdException {
		Flight flights = addFlightService.fetchByFlightId(flightId);
		if (flights != null) {
			addFlightService.save(flight);
			return "UPDATED";
		}
		return null;

	}

	@DeleteMapping(value = "/removeFlight/{flightId}")
	public String removeFlight(@PathVariable int flightId) throws NoFlightIdException

	{ Flight flight=addFlightService.fetchByFlightId(flightId);
	if(flight!=null)
		 return addFlightService.deleteById(flight);
	return null;

	}
}
