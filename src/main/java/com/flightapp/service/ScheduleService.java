package com.flightapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IScheduleDAO;
import com.flightapp.entities.Schedule;

@Service
public class ScheduleService implements IScheduleService {

	@Autowired
	IScheduleDAO scheduleDAO;
	
	Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);
	
	@Override
	public Schedule addSchedule(Schedule schedule) throws Exception {
		if(schedule.getDepartureTime().after(schedule.getArrivalTime())) {
			LOGGER.warn("Departure Time Should be less than arrival time");
			throw new Exception("Departure Time is After the Arriavl Time");
		}
		if(schedule.getDestinationAirport().getAirportId() == schedule.getSourceAirport().getAirportId()) {
			LOGGER.warn("Destination and Source Cannot be Same");
			throw new Exception("Destination and Source Airport are Same");
		}
		
		LOGGER.info("schedule has been saved");
		return scheduleDAO.save(schedule);
	}

	@Override
	public Schedule getScheduleById(int scheduleId) throws Exception {
		// TODO Auto-generated method stub
		if(scheduleDAO.existsById(scheduleId)) {
			LOGGER.info("Schedule exists at given ID");
			return scheduleDAO.getOne(scheduleId);
		}
		else {
			LOGGER.warn("No Schedule Exists");
			throw new Exception("No Schedule Exists by this ID");
		}
	}

	@Override
	public void removeSchedule(Schedule schedule) throws Exception {
		if(scheduleDAO.existsById(schedule.getScheduleId())) {
			LOGGER.info("Schedule exists at given ID");
			scheduleDAO.delete(schedule);
		}
		else {
			LOGGER.warn("No Schedule Exists");
			throw new Exception("No Schedule Exists by this ID");
		}
	}

	@Override
	public List<Schedule> getAllSchedules() throws Exception {
		LOGGER.info("getting list of schedules");
		List<Schedule> schedules = scheduleDAO.findAll();
		if(schedules.size() == 0) {
			throw new Exception("No Schedules Found");
		}
		else {
			return schedules;
		}
	}

}