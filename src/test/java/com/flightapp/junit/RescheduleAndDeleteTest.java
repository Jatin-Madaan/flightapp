package com.flightapp.junit;

import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Schedule;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.RescheduleException;
import com.flightapp.service.IRescheduleAndDeleteService;

@SpringBootTest
public class RescheduleAndDeleteTest 
{
	@Autowired
	IRescheduleAndDeleteService rescheduleAndDeleteService;
	
	@Test
	public void idNotFoundTest() throws RescheduleException
	{
		Assertions.assertThrows(RescheduleException.class, () -> {
			rescheduleAndDeleteService.removeFlightById(01);
		});
	}
	
	@Test
	public void timeStampAreSameTest() throws Exception
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Assertions.assertThrows(Exception.class, () -> {
			ScheduleFlight obj = rescheduleAndDeleteService.rescheduleFlightSchedule(15, arrivalTime , departureTime );
		});
	}
	
	@Test
	public void arrivalTimeTest1() throws Exception
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2021, 1, 1, 15, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.now());
		Assertions.assertThrows(Exception.class, () -> {
			ScheduleFlight obj = rescheduleAndDeleteService.rescheduleFlightSchedule(15, arrivalTime , departureTime );
		});
	}
	
	@Test
	public void arrivalTimeTest2() throws Exception
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2021, 1, 1, 15, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Assertions.assertThrows(Exception.class, () -> {
			ScheduleFlight obj = rescheduleAndDeleteService.rescheduleFlightSchedule(15, arrivalTime , departureTime );
		});
	}
	
	@Test
	public void invalidIdTest() throws Exception
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 15, 00));
		Assertions.assertThrows(Exception.class, () -> {
			ScheduleFlight msg = rescheduleAndDeleteService.rescheduleFlightSchedule(15, arrivalTime , departureTime );
		});
	}
	
//	@Test
//	public void validTimestampIdTest() throws Exception
//	{
//		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2021, 1, 1, 15, 00));
//		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.now());
//		ScheduleFlight obj = rescheduleAndDeleteService.rescheduleFlightSchedule(11111, arrivalTime , departureTime );
//		assertNotNull(obj);
//	}
}