package com.flightapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IScheduleFlightDAO;
import com.flightapp.entities.ScheduleFlight;

@Service
public class ScheduleFlightService implements IScheduleFlightService {
	@Autowired
	IScheduleFlightDAO scheduleFlightDAO;
	
	Logger LOGGER = LoggerFactory.getLogger(ScheduleFlightService.class);
	
	@Override
	public ScheduleFlight addScheduleFlight(ScheduleFlight scheduleFlight) throws Exception{
		LOGGER.info("adding scheduleFlight");
		return scheduleFlightDAO.save(scheduleFlight);
	}

	@Override
	public ScheduleFlight getScheduleFlightById(int scheduleFlightId) throws Exception {
		LOGGER.info("getting ScheduleFlight by Id");
		if(scheduleFlightDAO.existsById(scheduleFlightId)) {
			return scheduleFlightDAO.getOne(scheduleFlightId);
		}
		else {
			throw new Exception("schedule flight id doesn't exists");
		}
	}

	@Override
	public void removeScheduleFlight(ScheduleFlight scheduleFlight) throws Exception{
		LOGGER.info("removing ScheduleFlight");
		scheduleFlightDAO.delete(scheduleFlight);
	}

	@Override
	public List<ScheduleFlight> getAllScheduleFlights() throws Exception{
		LOGGER.info("getting ScheduleFlights list");
		List<ScheduleFlight> scheduleList = scheduleFlightDAO.findAll();
		if(scheduleList.size() == 0) {
			throw new Exception("No Scheduled Flights Exists");
		}
		return scheduleList;
	}

}