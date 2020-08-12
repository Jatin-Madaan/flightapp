package com.flightapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IAirportDAO;
import com.flightapp.entities.Airport;

@Service
public class AirportService implements IAirportService {

	@Autowired
	IAirportDAO airportDAO;
	
	Logger logger = LoggerFactory.getLogger(AirportService.class);
	
	@Override
	public List<Airport> getAllAirports() throws Exception {
		logger.info("getting all airports");
		return airportDAO.findAll();
	}

	@Override
	public Airport getAirportById(int airportId) throws Exception {
		// TODO Auto-generated method stub
		if(airportDAO.existsById(airportId)) {
			return airportDAO.getOne(airportId);
		}
		throw new Exception("Airport ID Doesn't exists");
	}

	@Override
	public Airport addAirport(Airport airport) throws Exception {
		return airportDAO.save(airport);
	}

}
