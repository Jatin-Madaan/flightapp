package com.flightapp.service;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightapp.dao.IScheduleFlightDAO;
import com.flightapp.entities.ScheduleFlight;

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
	public String removeFlightById(int id) 
	{
		if(scheduleFlight.existsById(id))
		{
			scheduleFlight.deleteById(id);
			return "Successfully Deleted";
		}
		else
		{
			return "Schedule not deleted";
		}
	}
	@Override
	public String rescheduleFlightSchedule(ScheduleFlight reschedule, Timestamp arrivalTime, Timestamp departureTime) 
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
			if(scheduleFlight.existsById(reschedule.getScheduleFlightId()))
			{
				reschedule.getSchedule().setArrivalTime(arrivalTime);
				reschedule.getSchedule().setDepartureTime(departureTime);
				return "Successfully Rescheduled";
			}
			else
			{
				return "Rescheduling Failed";
			}
		}
	}
}