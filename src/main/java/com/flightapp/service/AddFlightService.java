package com.flightapp.service;

import java.util.List;


import com.flightapp.dao.IFlightDao;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;

public class AddFlightService implements IAddFlightService{

	private IFlightDao flightDao;
	
	public AddFlightService(IFlightDao flightDao) {
		// TODO Auto-generated constructor stub
		this.flightDao = flightDao;
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
	public Flight fetchByFlightId(int flightId) {
		// TODO Auto-generated method stub
		return flightDao.findById(flightId).get();
	}

	@Override
	public void deleteById(int flightId) {
		// TODO Auto-generated method stub
		 flightDao.deleteById(flightId);
	}
	
	
}
