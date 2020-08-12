package com.flightapp.service;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightapp.dao.IScheduleFlightDAO;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.IdNotFoundException;

@Service
public class FlightAppRescheduleFlightService implements IFlightAppRescheduleFlightService 
{	
	@Autowired
	IScheduleFlightDAO scheduleFlight;
	@Override
	public java.util.List<ScheduleFlight> viewAllFlightSchedules() 
	{
		return scheduleFlight.findAll();
	}
	@Override
	public String removeFlightById(int scheduleFlightId) 
	{
		if(scheduleFlight.existsById(scheduleFlightId))
		{
			scheduleFlight.deleteById(scheduleFlightId);
			return "Successfully Deleted";
		}
		else
		{
			return "Schedule not deleted because ID not Found";
		}
	}
	@Override
	public String rescheduleFlightSchedule(int rescheduleId, Timestamp arrivalTime, Timestamp departureTime) 
	{
		if(arrivalTime.compareTo(departureTime) == 0)
		{
			return "Arrivaltime and Departuretime can not be euqal";
		}
		else if(arrivalTime.compareTo(departureTime) > 0)
		{
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
				}).orElseThrow(() -> new IdNotFoundException("customer not found with id " + rescheduleId));
				
				return "Successfully Rescheduled";
			}
			else
			{
				return "Rescheduling Failed because Id not found";
			}
		}
	}
}