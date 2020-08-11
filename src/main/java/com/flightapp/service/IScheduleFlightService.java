package com.flightapp.service;

import com.flightapp.entities.ScheduleFlight;

public interface IScheduleFlightService {
	ScheduleFlight addScheduleFlight(ScheduleFlight scheduleFlight);
	ScheduleFlight getScheduleFlightById(int scheduleFlightId);
	void removeScheduleFlight(ScheduleFlight scheduleFlight);
}
