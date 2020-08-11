package com.flightapp.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.service.IFlightAppRescheduleFlightService;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "*")
public class ReschedulingController 
{
	@Autowired
	IFlightAppRescheduleFlightService rescheduleFlightService;
	
	@GetMapping(path="/viewAll")
	public List<ScheduleFlight> getbookingbyid() 
	{
		return rescheduleFlightService.viewAllFlightSchedules();
	}
	
	@DeleteMapping(path="/deleteSchedule/{scheduleFlightId}")
	public String removeSchedule(@PathVariable int scheduleFlightId)
	{
		return rescheduleFlightService.removeFlightById(scheduleFlightId);
	}
	
	@PutMapping(path="/rescheduleFlightSchedule/{rescheduleId}/{arrivalTime}/{departureTime}")
	public String rescheduleFlightSchedule(int rescheduleId, Timestamp arrivalTime, Timestamp departureTime)
	{
		return rescheduleFlightService.rescheduleFlightSchedule(rescheduleId, arrivalTime, departureTime);
	}
}
