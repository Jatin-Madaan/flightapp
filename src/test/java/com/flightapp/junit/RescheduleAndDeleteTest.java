package com.flightapp.junit;

import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.flightapp.service.IRescheduleAndDeleteService;

@SpringBootTest
public class RescheduleAndDeleteTest 
{
	@Autowired
	IRescheduleAndDeleteService rescheduleAndDeleteService;
	
	@Test
	public void idNotFoundTest() 
	{
		String msg = rescheduleAndDeleteService.removeFlightById(01);
		assertEquals(msg, "Schedule not deleted because ID not Found");
	}
	
	@Test
	public void timeStampAreSameTest() 
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		String msg = rescheduleAndDeleteService.rescheduleFlightSchedule(15, arrivalTime , departureTime );
		assertEquals(msg,"Arrivaltime and Departuretime can not be euqal");
	}
	
	@Test
	public void arrivalTimeTest1() 
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2021, 1, 1, 15, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.now());
		String msg = rescheduleAndDeleteService.rescheduleFlightSchedule(15, arrivalTime , departureTime );
		assertEquals(msg, "Arrivaltime can not be less then Departuretime");
	}
	
	@Test
	public void arrivalTimeTest2() 
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2021, 1, 1, 15, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		String msg = rescheduleAndDeleteService.rescheduleFlightSchedule(15, arrivalTime , departureTime );
		assertEquals(msg, "Arrivaltime can not be less then Departuretime");
	}
	
	@Test
	public void invalidIdTest() 
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 14, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.of(2020, 10, 1, 15, 00));
		String msg = rescheduleAndDeleteService.rescheduleFlightSchedule(15, arrivalTime , departureTime );
		assertEquals(msg, "Rescheduling Failed because Id not found");
	}
	
	@Test
	public void validTimestampIdTest() 
	{
		Timestamp arrivalTime = Timestamp.valueOf(LocalDateTime.of(2021, 1, 1, 15, 00));
		Timestamp departureTime = Timestamp.valueOf(LocalDateTime.now());
		String msg = rescheduleAndDeleteService.rescheduleFlightSchedule(11111, arrivalTime , departureTime );
		assertEquals(msg, "Arrivaltime can not be less then Departuretime");
	}
}