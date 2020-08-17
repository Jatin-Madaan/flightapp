package com.flightapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IScheduleFlightDAO;
import com.flightapp.entities.Flight;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.NoFlightsAvaliableException;

@Service
public class GetFlightService implements IGetFlightService {
	
	@Autowired
	IScheduleFlightDAO scheduleFlight;
	
	Logger logger = LoggerFactory.getLogger(GetFlightService.class);

	/**
	 * Method: getFlights
	 * Description: Used to fetch all the flights between Given source and destination.
	 * @param source: Source airport location
	 * @param destination: Destination airport location
	 * @param searchDate: Date, for which user want to search flights
	 * @return List: It returns the list of scheduled flights
	 * @author Adithya 
	 */
	@Override
	public List<ScheduleFlight> getFlights(String source, String destination, LocalDate searchDate,int passengers) throws NoFlightsAvaliableException {
				

		logger.info("Fetching scheduled flights between "+source+" - "+destination);
		
		List<ScheduleFlight> scheduleFlightObjs = scheduleFlight.findAll();
		
		List<ScheduleFlight> scheduleFlights = new ArrayList<ScheduleFlight>();
		
		if(!scheduleFlightObjs.isEmpty())
		{
		
		for(ScheduleFlight scheduleFlightObj: scheduleFlightObjs)
		{		
			if(scheduleFlightObj.getSchedule().getSourceAirport().getAddress().equals(source) && scheduleFlightObj.getSchedule().getDestinationAirport().getAddress().equals(destination)
				&& scheduleFlightObj.getAvailableSeats()>passengers
				&& scheduleFlightObj.getSchedule().getDepartureTime().toLocalDateTime().toLocalDate().equals(searchDate)) 
			{				
					scheduleFlights.add(scheduleFlightObj);
			}
		}
		}
		
		if(scheduleFlightObjs.isEmpty() || scheduleFlights.isEmpty())
		{
			logger.error("No scheduled flights available between "+source+" - "+destination);
			throw new NoFlightsAvaliableException("No scheduled flights available");					
		}
		
		logger.info("Returning scheduled flights between "+source+" - "+destination);
		return scheduleFlights;
	}
}
