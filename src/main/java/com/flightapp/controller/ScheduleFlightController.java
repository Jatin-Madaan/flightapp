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
import com.flightapp.service.IScheduleFlightService;

@CrossOrigin(origins = "*")
@RestController
@ControllerAdvice
public class ScheduleFlightController {

	@Autowired
	IScheduleFlightService scheduleFlightService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/scheduleFlight/add")
	public ScheduleFlight addScheduleFlight(@RequestBody ScheduleFlight scheduleFlight) throws Exception {
		return scheduleFlightService.addScheduleFlight(scheduleFlight);
	}

	@RequestMapping(method = RequestMethod.GET, value="/scheduleFlight/id/{scheduleFlightId}")
	public ScheduleFlight getScheduleFlightById(@PathVariable int scheduleFlightId) throws Exception {
		return scheduleFlightService.getScheduleFlightById(scheduleFlightId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/scheduleFlight/remove")
	public void removeScheduleFlight(@RequestBody ScheduleFlight scheduleFlight) throws Exception {
		scheduleFlightService.removeScheduleFlight(scheduleFlight);
	}
	
	@RequestMapping("/scheduleFlight/all")
	public List<ScheduleFlight> getAllScheduleFlights() throws Exception{
		return scheduleFlightService.getAllScheduleFlights();
	}
}
