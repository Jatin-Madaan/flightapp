package com.flightapp.service;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightapp.dao.IScheduleFlightDAO;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.RescheduleException;

@Service
public class RescheduleAndDeleteService implements IRescheduleAndDeleteService 
{	
	@Autowired
	IScheduleFlightDAO scheduleFlight;
	
	Logger logger = LoggerFactory.getLogger(RescheduleAndDeleteService.class);
	
	@Override
	public java.util.List<ScheduleFlight> viewAllFlightSchedules() 
	{
		return scheduleFlight.findAll();
	}
	@Override
	public String removeFlightById(int scheduleFlightId) 
	{
		logger.info("checking id exists for deleting schedule");
		if(scheduleFlight.existsById(scheduleFlightId))
		{
			scheduleFlight.deleteById(scheduleFlightId);
			logger.info("Successfully Deleted");
			return "Successfully Deleted";
		}
		else
		{
			logger.warn("Schedule not deleted because ID not Found");
			return "Schedule not deleted because ID not Found";
		}
	}
	@Override
	public String rescheduleFlightSchedule(int rescheduleId, Timestamp arrivalTime, Timestamp departureTime) 
	{
		if(arrivalTime.compareTo(departureTime) == 0)
		{
			logger.error("Arrivaltime and Departuretime can not be euqal");
			return "Arrivaltime and Departuretime can not be euqal";
		}
		else if(arrivalTime.compareTo(departureTime) > 0)
		{
			logger.error("Arrivaltime can not be less then Departuretime");
			return "Arrivaltime can not be less then Departuretime";
		}
		else    																				//Arrival time is be greater then Departure time
		{
			if(scheduleFlight.existsById(rescheduleId))
			{
				scheduleFlight.findById(rescheduleId).map( reschedule ->
				{
					reschedule.getSchedule().setArrivalTime(arrivalTime);
					reschedule.getSchedule().setDepartureTime(departureTime);
					return scheduleFlight.save(reschedule);
				}).orElseThrow(() -> new RescheduleException("customer not found with id " + rescheduleId));
				logger.info("Successfully Rescheduled");
				return "Successfully Rescheduled";
			}
			else
			{
				logger.error("Rescheduling Failed because Id not found");
				return "Rescheduling Failed because Id not found";
			}
		}
	}
}