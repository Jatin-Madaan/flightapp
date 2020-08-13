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
	
	/**
	 * Method: viewAllFlightSchedules
	 * Description: Used to fetch that List of all the ScheduleFlight.
	 * @return List: It returns the list of ScheduledFlight
	 * @author YashYo
	 */
	@Override
	public java.util.List<ScheduleFlight> viewAllFlightSchedules() 
	{
		return scheduleFlight.findAll();
	}
	
	/**
	 * Method: removeFlightById
	 * Description: Used to delete the ScheduleFlight via givin Id.
	 * @param int: scheduleFlightId
	 * @return List: It returns feedback message.
	 * @author YashYo
	 */
	@Override
	public void removeFlightById(int scheduleFlightId) throws RescheduleException
	{
		logger.info("checking id exists for deleting schedule");
		if(scheduleFlight.existsById(scheduleFlightId))
		{
			scheduleFlight.deleteById(scheduleFlightId);
			logger.info("Successfully Deleted");
		}
		else
		{
			logger.warn("Schedule not deleted because ID not Found");
			throw new RescheduleException("Schedule not deleted because ID not Found");
		}
	}
	
	/**
	 * Method: rescheduleFlightSchedule
	 * Description: Used to delete the ScheduleFlight via givin Id.
	 * @param int: rescheduleId
	 * @param Timestamp: arrivalTime
	 * @param Timestamp: departureTime
	 * @return List: It returns feedback message.
	 * @author YashYo
	 */
	@Override
	public ScheduleFlight rescheduleFlightSchedule(int rescheduleId, Timestamp arrivalTime, Timestamp departureTime) throws RescheduleException 
	{
		if(arrivalTime.compareTo(departureTime) == 0)
		{
			logger.error("Arrivaltime and Departuretime can not be euqal");
			throw new RescheduleException("Arrivaltime and Departuretime can not be euqal");
		}
		else if(arrivalTime.compareTo(departureTime) > 0)
		{
			logger.error("Arrivaltime can not be less then Departuretime");
			throw new RescheduleException("Arrivaltime can not be less then Departuretime");
		}
		else    																				//Arrival time is be greater then Departure time
		{
			if(scheduleFlight.existsById(rescheduleId))
			{
				ScheduleFlight reschedule = scheduleFlight.getOne(rescheduleId);
				reschedule.getSchedule().setArrivalTime(arrivalTime);
				reschedule.getSchedule().setDepartureTime(departureTime);
				
				logger.info("Successfully Rescheduled");
				return scheduleFlight.save(reschedule);
			}
			else
			{
				logger.error("Rescheduling Failed because Id not found");
				throw new RescheduleException("Rescheduling Failed because Id not found");
			}
		}
	}
}