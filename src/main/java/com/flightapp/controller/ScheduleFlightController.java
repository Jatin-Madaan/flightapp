package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ScheduleFlightController {

	@Autowired
	IScheduleFlightService scheduleFlightService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/scheduleFlight/add")
	public ScheduleFlight addScheduleFlight(@RequestBody ScheduleFlight scheduleFlight) {
		return scheduleFlightService.addScheduleFlight(scheduleFlight);
	}

	@RequestMapping("/scheduleFlight/id/{scheduleFlightId")
	public ScheduleFlight getScheduleFlightById(@PathVariable int scheduleFlightId) {
		return scheduleFlightService.getScheduleFlightById(scheduleFlightId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/scheduleFlight/remove")
	public void removeScheduleFlight(@RequestBody ScheduleFlight scheduleFlight) {
		scheduleFlightService.removeScheduleFlight(scheduleFlight);
	}
}
