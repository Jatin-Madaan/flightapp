package com.flightapp.service;

import java.util.List;

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
		System.out.println(scheduleFlight);
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

	@Override
	public List<ScheduleFlight> getAllScheduleFlights() {
		return scheduleFlightDAO.findAll();
	}

}
