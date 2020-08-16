package com.flightapp.junit;

import static org.junit.Assert.assertNotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Airport;
import com.flightapp.entities.Schedule;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.RescheduleException;
import com.flightapp.service.IAirportService;
import com.flightapp.service.IRescheduleAndDeleteService;

@SpringBootTest
public class RescheduleAndDeleteTest 
{
	@Autowired
	IRescheduleAndDeleteService rescheduleAndDeleteService;
	@Autowired
	IAirportService airportService;
	
	@Test
	public void idNotFoundTest() throws RescheduleException
	{
		Assertions.assertThrows(RescheduleException.class, () -> {
			rescheduleAndDeleteService.removeFlightById(01);
		});
	}
	
	@Test
	public void idFoundButBookedTest() throws RescheduleException
	{
		Assertions.assertThrows(RescheduleException.class, () -> {
			rescheduleAndDeleteService.removeFlightById(11117);
		});
	}
	
	@Test
	public void timeStampAreSameTest() throws RescheduleException
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Airport destAirport = new Airport("PAT", "Patna");
		Airport srcAirport = new Airport("CHN", "Chennai");
		Schedule schedule = new Schedule(srcAirport, destAirport, departureTime, arrivalTime);
		ScheduleFlight updatedScheduleFlight = new ScheduleFlight(11117, schedule);
		Assertions.assertThrows(RescheduleException.class, () -> {
			rescheduleAndDeleteService.rescheduleFlightSchedule(15, updatedScheduleFlight);
		});
	}
	
	@Test
	public void arrivalTimeTest1() throws RescheduleException
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2021, 1, 1, 15, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.now());
		Airport destAirport = new Airport("PAT", "Patna");
		Airport srcAirport = new Airport("CHN", "Chennai");
		Schedule schedule = new Schedule(srcAirport, destAirport, departureTime, arrivalTime);
		ScheduleFlight updatedScheduleFlight = new ScheduleFlight(11117, schedule);
		Assertions.assertThrows(RescheduleException.class, () -> {
			rescheduleAndDeleteService.rescheduleFlightSchedule(15, updatedScheduleFlight);
		});
	}
	
	@Test
	public void arrivalTimeTest2() throws RescheduleException
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2021, 1, 1, 15, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Airport destAirport = new Airport("PAT", "Patna");
		Airport srcAirport = new Airport("CHN", "Chennai");
		Schedule schedule = new Schedule(srcAirport, destAirport, departureTime, arrivalTime);
		ScheduleFlight updatedScheduleFlight = new ScheduleFlight(11117, schedule);
		Assertions.assertThrows(RescheduleException.class, () -> {
			rescheduleAndDeleteService.rescheduleFlightSchedule(15, updatedScheduleFlight);
		});
	}
	
	@Test
	public void invalidIdTest() throws RescheduleException
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 15, 00));
		Airport destAirport = new Airport("PAT", "Patna");
		Airport srcAirport = new Airport("CHN", "Chennai");
		Schedule schedule = new Schedule(srcAirport, destAirport, departureTime, arrivalTime);
		ScheduleFlight updatedScheduleFlight = new ScheduleFlight(11117, schedule);
		Assertions.assertThrows(RescheduleException.class, () -> {
			rescheduleAndDeleteService.rescheduleFlightSchedule(15, updatedScheduleFlight);
		});
	}
	
	@Test
	public void validTimestampIdTest() throws Exception
	{
		Timestamp arrivalTime = Timestamp.valueOf("2021-01-01 15:00:00");
		Timestamp departureTime = Timestamp.valueOf("2020-12-31 14:00:00");
		Airport destAirport = new Airport("PAT", "Patna");
		Airport srcAirport = new Airport("CHN", "Chennai");
		Schedule schedule = new Schedule(srcAirport, destAirport, departureTime, arrivalTime);
		ScheduleFlight updatedScheduleFlight = new ScheduleFlight(11117, schedule);
		ScheduleFlight obj = rescheduleAndDeleteService.rescheduleFlightSchedule(11117, updatedScheduleFlight);
		assertNotNull(obj);
	}
}