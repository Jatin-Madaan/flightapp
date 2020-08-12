package com.flightapp.mokitotest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Schedule;
import com.flightapp.service.FlightServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FlightAppRescheduleTest 
{
	
	@Mock
	FlightDAO flightDao;
	@InjectMocks
	FlightServiceImpl flightService;
	
	@Test
	public void isNull() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(null);
		schedule.setArrivalTime(null);	
		
		when(flightDao.modifySchedule(schedule)).thenReturn("wrong");
		String msg = flightService.modifySchedule(schedule);
		assertEquals(msg,"wrong");
//		assertThat(msg, is("wrong"));
	}
	
	@Test
	public void isDeprtTimeInvalid() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00)));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.now()));	
		
		when(flightDao.modifySchedule(schedule)).thenReturn("wrong");
		String msg = flightService.modifySchedule(schedule);
		assertEquals(msg,"wrong");
//		assertThat(msg, is("wrong"));
	}
	
	@Test
	public void isDeprtTimeValid() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.now()));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 15, 00)));	
		
		when(flightDao.modifySchedule(schedule)).thenReturn("ok");
		String msg = flightService.modifySchedule(schedule);
		assertEquals(msg, "ok");
//		assertThat(msg, is("ok"));
	}
	
	@Test
	public void isNotNullValid() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00)));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 15, 00)));	
		
		when(flightDao.modifySchedule(schedule)).thenReturn("ok");
		String msg = flightService.modifySchedule(schedule);
		assertEquals(msg, "ok");
//		assertThat(msg, is("ok"));
	}
	
	@Test
	public void isNotNullButInvalid() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 15, 00)));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00)));	
		
		when(flightDao.modifySchedule(schedule)).thenReturn("wrong");
		String msg = flightService.modifySchedule(schedule);
		assertEquals(msg,"wrong");
//		assertThat(msg, is("wrong"));
	}
}
