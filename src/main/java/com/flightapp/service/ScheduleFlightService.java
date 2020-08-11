package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IScheduleFlightDAO;
import com.flightapp.entities.ScheduleFlight;

@Service
public class ScheduleFlightService implements IScheduleFlightService {
	@Autowired
	IScheduleFlightDAO scheduleFlightDAO;


	@Override
	public ScheduleFlight addScheduleFlight(ScheduleFlight scheduleFlight) {
		return scheduleFlightDAO.save(scheduleFlight);
	}

	@Override
	public ScheduleFlight getScheduleFlightById(int scheduleFlightId) {
		return scheduleFlightDAO.getOne(scheduleFlightId);
	}

	@Override
	public void removeScheduleFlight(ScheduleFlight scheduleFlight) {
		scheduleFlightDAO.delete(scheduleFlight);
	}

}
