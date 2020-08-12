package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.ScheduleFlight;

public interface IScheduleFlightService {
	ScheduleFlight addScheduleFlight(ScheduleFlight scheduleFlight) throws Exception;
	ScheduleFlight getScheduleFlightById(int scheduleFlightId) throws Exception ;
	void removeScheduleFlight(ScheduleFlight scheduleFlight) throws Exception;
	List<ScheduleFlight> getAllScheduleFlights() throws Exception;
}
