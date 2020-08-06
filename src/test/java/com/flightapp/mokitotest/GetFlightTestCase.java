package com.flightapp.mokitotest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.service.FlightServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class GetFlightTestCase {

FlightDAO dao = Mockito.mock(FlightDAO.class);
	
	FlightServiceImpl service = new FlightServiceImpl(dao);
	
	LocalDateTime now = LocalDateTime.now();  
	
	LocalTime myObj = LocalTime.now();
	
	Date date = new Date();
	
	
	@Test
	void getFlightstest() {
		Flight flight  = new Flight();
		flight.setFlightId(1);
		flight.setCarrierName("Indigo");
		flight.setFlightModel("CEO");
		flight.setSeatCapacity(150);
		Airport airport1 = new Airport();
		airport1.setAirportId(1);
		airport1.setAddress("Coimbatore");
		airport1.setAirportName("CBE");
		Airport airport2 = new Airport();
		airport2.setAirportId(2);
		airport2.setAddress("Chennai");
		airport2.setAirportName("MDS");
		Schedule schedule = new Schedule();
		schedule.setDestinationAirport(airport2);
		schedule.setSourceAirport(airport1);
		schedule.setDepartureTime(LocalDateTime.now());
		schedule.setArrivalTime(LocalDateTime.of(2020, 2, 13, 15, 56));
		ScheduleFlight scheduleflight = new ScheduleFlight();
		scheduleflight.setFlight(flight);
		scheduleflight.setSchedule(schedule);
		scheduleflight.setAvailableSeats(148);
		
		List<Flight> flights = new ArrayList<>();
		flights.add(scheduleflight.getFlight());
		
		when(dao.getFlights("Coimbatore", "Chennai")).thenReturn(flights);
		assertEquals(flights, service.getFlights("Coimbatore", "Chennai"));
		
		when(dao.getFlights("Coimbatore", "Hyderabad")).thenReturn(null);
		assertEquals(null, service.getFlights("Coimbatore", "Hyderabad"));
		
	}

}
