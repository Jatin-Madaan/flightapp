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

import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.ScheduleException;
import com.flightapp.exception.ScheduleFlightException;
import com.flightapp.service.IScheduleFlightService;

/**
 * @author Jatin
 *
 */
@CrossOrigin(origins = "*")
@RestController
@ControllerAdvice
public class ScheduleFlightController {

	@Autowired
	IScheduleFlightService scheduleFlightService;
	
	/**
	 * Method: addScheduleFlight
	 * Description: For adding ScheduleFlight Obj to Table
	 * @param scheduleFlight
	 * @return ScheduleFlight
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/scheduleFlight/add")
	public ScheduleFlight addScheduleFlight(@RequestBody ScheduleFlight scheduleFlight) throws ScheduleFlightException {
		return scheduleFlightService.addScheduleFlight(scheduleFlight);
	}

	/**
	 * Method: getScheduleFlightById
	 * Description: For getting ScheduleFlight Obj by providing Id
	 * @param scheduleFlightId
	 * @return ScheduleFlight
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value="/scheduleFlight/id/{scheduleFlightId}")
	public ScheduleFlight getScheduleFlightById(@PathVariable int scheduleFlightId) throws ScheduleFlightException {
		return scheduleFlightService.getScheduleFlightById(scheduleFlightId);
	}
	
	/**
	 * Method: removeScheduleFlight
	 * Description: For removing ScheduleFlight Obj from  table
	 * @param scheduleFlight
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/scheduleFlight/remove")
	public void removeScheduleFlight(@RequestBody ScheduleFlight scheduleFlight) throws ScheduleFlightException {
		scheduleFlightService.removeScheduleFlight(scheduleFlight);
	}
	
	/**
	 * Method: getAllScheduleFlights
	 * Description: For getting lists of ScheduledFlight objects 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/scheduleFlight/all")
	public List<ScheduleFlight> getAllScheduleFlights() throws ScheduleFlightException{
		return scheduleFlightService.getAllScheduleFlights();
	}
}
