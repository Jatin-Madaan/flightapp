package com.flightapp.service;

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
	public List<Flight> getFlights(String source, String destination, LocalDateTime searchDate) throws NoFlightsAvaliableException {
				

		logger.info("Fetching scheduled flights between "+source+" - "+destination);
		
		List<ScheduleFlight> scheduleFlightObjs = scheduleFlight.findAll();
		
		List<Flight> flights = new ArrayList<Flight>();
		
		if(!scheduleFlightObjs.isEmpty())
		{
		
		for(int i=0;i<scheduleFlightObjs.size();i++)
		{			
			if(scheduleFlightObjs.get(i).getSchedule().getSourceAirport().getAddress().equals(source) && scheduleFlightObjs.get(i).getSchedule().getDestinationAirport().getAddress().equals(destination)
				&& scheduleFlightObjs.get(i).getAvailableSeats()>0)
//					&& scheduleFlightObjs.get(i).getSchedule().getDepartureTime().toLocalDateTime().equals(searchDate)) 
			{				
					flights.add(scheduleFlightObjs.get(i).getFlight());
			}
		}
		}
		
		if(scheduleFlightObjs.isEmpty() || flights.isEmpty())
		{
			logger.error("No scheduled flights available between "+source+" - "+destination);
			throw new NoFlightsAvaliableException("No scheduled flights available");					
		}
		
		logger.info("Returning scheduled flights between "+source+" - "+destination);
		return flights;
	}
}
