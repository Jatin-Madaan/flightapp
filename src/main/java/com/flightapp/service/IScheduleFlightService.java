package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.ScheduleFlightException;

public interface IScheduleFlightService {
	ScheduleFlight addScheduleFlight(ScheduleFlight scheduleFlight) throws ScheduleFlightException;
	ScheduleFlight getScheduleFlightById(int scheduleFlightId) throws ScheduleFlightException ;
	void removeScheduleFlight(ScheduleFlight scheduleFlight) throws ScheduleFlightException;
	List<ScheduleFlight> getAllScheduleFlights() throws ScheduleFlightException;
}
