package com.flightapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IFlightDao;
import com.flightapp.entities.Flight;
import com.flightapp.exception.NoFlightIdException;

@Service
public class AddFlightService implements IAddFlightService {

	@Autowired
	IFlightDao flightDao;

	Logger logger = LoggerFactory.getLogger(AddFlightService.class);

	public AddFlightService() {

	}

	/**
	 * Method: save Description: save the flight object
	 * @param flight: flight object
	 * @return flight object: It returns an object of Flight table
	 * @author Ravinder Karu
	 */
	@Override
	public Flight save(Flight flight) {
		
		logger.info("new Flight is Adding to database");
		return flightDao.save(flight);

	}

	/**
	 * Method: fetchAll Description: get the flight Details
	 * @return List <flight>: It returns list of flight objects
	 * @author Ravinder Karu
	 */
	@Override
	public List<Flight> fetchAll() {

		logger.info("Retrieving the flight data from flight table");
		return flightDao.findAll();
	}

	/**
	 * Method: fetchByFlightId Description: get the flight Details
	 * @param flightId: FlightId of Flight
	 * @return flight object: It returns an object of Flight table
	 * @author Ravinder Karu
	 */
	@Override
	public Flight fetchByFlightId(int flightId) throws NoFlightIdException {


		if (flightDao.existsById(flightId)) {
			logger.info("Retrieving the data from flight table based on flightId");
			Flight flight = flightDao.findById(flightId).get();
			System.out.println(flight.toString());
			logger.info("sending data");
			return flight;
		} else
			logger.error("Flight Id is not found");
		throw new NoFlightIdException("Flight Id not found");
	}

	/**
	 * Method: deleteById Description: delete the flight from flight table
	 * @param flightId: FlightId of Flight
	 * @return message: It returns the status
	 * @author Ravinder Karu
	 */

	@Override
	public String deleteById(Flight flight) throws NoFlightIdException {

			logger.info("Deleting flight from Flight Table");
			flightDao.delete(flight);
			return "DELETED";

		

	}

}
