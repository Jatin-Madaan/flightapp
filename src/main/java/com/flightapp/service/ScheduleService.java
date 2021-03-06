package com.flightapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IScheduleDAO;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.ScheduleException;

/**
 * @author Jatin
 *
 */
@Service
public class ScheduleService implements IScheduleService {

	@Autowired
	IScheduleDAO scheduleDAO;
	
	Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);
	
	/**
	 * Method: addSchedule
	 * Description: adding schedule to table
	 * @param schedule
	 * @return Schedule
	 * @throws ScheduleException;
	 */
	@Override
	public Schedule addSchedule(Schedule schedule) throws ScheduleException {
		if(schedule.getDepartureTime().after(schedule.getArrivalTime())) {
			LOGGER.warn("Departure Time Should be less than arrival time");
			throw new ScheduleException("Departure Time is After the Arrival Time");
		}
		if(schedule.getDestinationAirport().getAirportId() == schedule.getSourceAirport().getAirportId()) {
			LOGGER.warn("Destination and Source Cannot be Same");
			throw new ScheduleException("Destination and Source Airport are Same");
		}
		
		LOGGER.info("schedule has been saved");
		return scheduleDAO.save(schedule);
	}

	/**
	 * Method: getScheduleById
	 * Description: getting schedule from table by providing id
	 * @param scheduleId
	 * @return Schedule
	 * @throws ScheduleException
	 */
	@Override
	public Schedule getScheduleById(int scheduleId) throws ScheduleException {
		// TODO Auto-generated method stub
		if(scheduleDAO.existsById(scheduleId)) {
			LOGGER.info("Schedule exists at given ID");
			return scheduleDAO.getOne(scheduleId);
		}
		else {
			LOGGER.warn("No Schedule Exists");
			throw new ScheduleException("No Schedule Exists by this ID");
		}
	}

	/**
	 * Method: removeSchedule
	 * Description: removing schedule from table 
	 * @param scheduleId
	 * @return
	 * @throws ScheduleException
	 */
	@Override
	public void removeSchedule(Schedule schedule) throws ScheduleException {
		if(scheduleDAO.existsById(schedule.getScheduleId())) {
			LOGGER.info("Schedule exists at given ID");
			scheduleDAO.delete(schedule);
		}
		else {
			LOGGER.warn("No Schedule Exists");
			throw new ScheduleException("No Schedule Exists by this ID");
		}
	}

	/**
	 * Method: getAllSchedules
	 * Description: getting lists of schedules from table
	 * @param 
	 * @return List<Schedule>
	 * @throws ScheduleException
	 */
	@Override
	public List<Schedule> getAllSchedules() throws ScheduleException {
		LOGGER.info("getting list of schedules");
		List<Schedule> schedules = scheduleDAO.findAll();
		if(schedules.size() == 0) {
			throw new ScheduleException("No Schedules Found");
		}
		else {
			return schedules;
		}
	}

}
