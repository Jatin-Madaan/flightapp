package com.flightapp.mokitotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;
import com.flightapp.service.FlightServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FlightAppScheduleTest {

	@Mock
	FlightDAO dao;
	
	@InjectMocks
	FlightServiceImpl service;
	
	@Test
	public void isLocationsBlank() {
		Flight flight = new Flight();
		flight.setFlightId(101);
		flight.setFlightModel("Boieng 747");
		flight.setSeatCapacity(100);
		
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Bombay");
		schedule.setDestinationAirport(null);
		schedule.setSourceAirport(null);
		schedule.setArrivalTime(LocalDateTime.now());
		schedule.setDepartureTime(LocalDateTime.of(2020, 2, 13, 15, 56));
		
		when(dao.scheduleFlight(10, flight, schedule)).thenReturn("Test Case Failed");
		String msg = service.scheduleFlight(10, flight, schedule);
		assertThat(msg, is("Test Case Failed"));
	}
	
	@Test
	public void isLocationsDifferent() {
		Flight flight = new Flight();
		flight.setFlightId(101);
		flight.setFlightModel("Boieng 747");
		flight.setSeatCapacity(100);
		
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Delhi");
		schedule.setDestinationAirport(new Airport());
		schedule.setSourceAirport(new Airport());
		schedule.setArrivalTime(LocalDateTime.now());
		schedule.setDepartureTime(LocalDateTime.of(2020, 2, 13, 15, 56));
		
		when(dao.scheduleFlight(10, flight, schedule)).thenReturn("Test Case Failed");
		String msg = service.scheduleFlight(10, flight, schedule);
		assertThat(msg, is("Test Case Failed"));
	}

}
