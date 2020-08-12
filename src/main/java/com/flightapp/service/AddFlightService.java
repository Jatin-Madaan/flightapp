package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IFlightDao;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.NoFlightIdException;

@Service
public class AddFlightService implements IAddFlightService {

	@Autowired
	IFlightDao flightDao;


	public AddFlightService() {

	}

	@Override
	public Flight save(Flight flight) {
		// TODO Auto-generated method stub
		return flightDao.save(flight);

	}

	@Override
	public List<Flight> fetchAll() {
		// TODO Auto-generated method stub
		return flightDao.findAll();
	}

	@Override
	public Flight fetchByFlightId(int flightId) throws NoFlightIdException {
		// TODO Auto-generated method stub

		if (flightDao.existsById(flightId)) {
			Flight flight = flightDao.findById(flightId).get();
			return flight;
		} else
			throw new NoFlightIdException("Flight Id not found");
	}

	@Override
	public String deleteById(int flightId) {
		// TODO Auto-generated method stub
		Flight flight = flightDao.findById(flightId).get();
		if (flight != null) {
			flightDao.deleteById(flightId);
			return "DELETED";

		}
		return null;

	}

}
