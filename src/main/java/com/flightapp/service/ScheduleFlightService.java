package com.flightapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IScheduleFlightDAO;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.ScheduleFlightException;

/**
 * @author Jatin
 *
 */
@Service
public class ScheduleFlightService implements IScheduleFlightService {
	@Autowired
	IScheduleFlightDAO scheduleFlightDAO;
	
	Logger LOGGER = LoggerFactory.getLogger(ScheduleFlightService.class);
	
	/**
	 * Method: addScheduleFlight
	 * Description: adding ScheduleFlight objs to table
	 * @param scheduleFlight
	 * @return ScheduleFlight
	 * @throws ScheduleFlightException
	 */
	@Override
	public ScheduleFlight addScheduleFlight(ScheduleFlight scheduleFlight) throws ScheduleFlightException{
		LOGGER.info("adding scheduleFlight");
		return scheduleFlightDAO.save(scheduleFlight);
	}

	/**
	 * Method: getScheduleFlightById
	 * Description: adding ScheduleFlight objs to table
	 * @param scheduleId
	 * @return ScheduleFlight
	 * @throws ScheduleFlightException
	 */
	@Override
	public ScheduleFlight getScheduleFlightById(int scheduleFlightId) throws ScheduleFlightException {
		LOGGER.info("getting ScheduleFlight by Id");
		if(scheduleFlightDAO.existsById(scheduleFlightId)) {
			return scheduleFlightDAO.getOne(scheduleFlightId);
		}
		else {
			throw new ScheduleFlightException("schedule flight id doesn't exists");
		}
	}

	/**
	 * Method: removeScheduleFlight
	 * Description: removing ScheduleFlight objs from table
	 * @param scheduleFlight
	 * @return ScheduleFlight
	 * @throws Exception
	 */
	@Override
	public void removeScheduleFlight(ScheduleFlight scheduleFlight) throws ScheduleFlightException{
		LOGGER.info("removing ScheduleFlight");
		scheduleFlightDAO.delete(scheduleFlight);
	}

	/**
	 * Method: getAllScheduleFlights
	 * Description: getting lists of ScheduleFlights Objects from table
	 * @param 
	 * @return List<ScheduleFlight>
	 * @throws Exception
	 */
	@Override
	public List<ScheduleFlight> getAllScheduleFlights() throws ScheduleFlightException{
		LOGGER.info("getting ScheduleFlights list");
		List<ScheduleFlight> scheduleList = scheduleFlightDAO.findAll();
		if(scheduleList.size() == 0) {
			throw new ScheduleFlightException("No Scheduled Flights Exists");
		}
		return scheduleList;
	}

}
