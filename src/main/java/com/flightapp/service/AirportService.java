package com.flightapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IAirportDAO;
import com.flightapp.entities.Airport;
import com.flightapp.exception.AirportException;

/**
 * @author Jatin
 *
 */
@Service
public class AirportService implements IAirportService {

	@Autowired
	IAirportDAO airportDAO;
	
	Logger logger = LoggerFactory.getLogger(AirportService.class);
	
	/**
	 * Method: getAllAirports
	 * Description: getting all airports in form lists
	 * @param 
	 * @return List<Airport>
	 * @throws AirportException
	 */
	@Override
	public List<Airport> getAllAirports() throws AirportException {
		logger.info("getting all airports");
		return airportDAO.findAll();
	}

	/**
	 * Method: getAirportById
	 * Description: getting a airport  by providing Airport
	 * @param airportId
	 * @return Airport
	 * @throws AirportException
	 */
	@Override
	public Airport getAirportById(int airportId) throws AirportException {
		// TODO Auto-generated method stub
		if(airportDAO.existsById(airportId)) {
			return airportDAO.getOne(airportId);
		}
		throw new AirportException("Airport ID Doesn't exists");
	}

	/**
	 * Method: addAirport
	 * Description: add a airport in table
	 * @param airport
	 * @return Airport
	 * @throws AirportException
	 */
	@Override
	public Airport addAirport(Airport airport) throws AirportException {
		return airportDAO.save(airport);
	}

}
