package com.flightapp.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.dao.IAirportDAO;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.AirportException;
import com.flightapp.exception.ScheduleException;
import com.flightapp.service.IAirportService;
import com.flightapp.service.IScheduleService;

@SpringBootTest
class ScheduleTest {

	@Autowired
	IAirportService airportService;
	
	@Autowired
	IScheduleService scheduleService;
	
	
	@Test
	void getScheduleByIdTest() throws ScheduleException{
		Schedule schedule = scheduleService.getScheduleById(41);
		assertEquals(41, schedule.getScheduleId());
	}
	
	@Test
	void addSchedule() throws ScheduleException, AirportException{
		Airport dest = new Airport("PAT", "Patna");
		Airport src = new Airport("CHN", "Chennai");
		
		Airport destAirport = airportService.addAirport(dest);
		Airport srcAirport = airportService.addAirport(src);
		
		assertEquals("PAT", destAirport.getAirportName());
		
		Schedule schedule = new Schedule(srcAirport, destAirport, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
		assertNotNull(schedule);
		
	}

	@Test
	void getScheduleByIdExceptionTest() throws ScheduleException{
		
		Assertions.assertThrows(ScheduleException.class, () -> {
			Schedule schedule = scheduleService.getScheduleById(789);
		});
	}
	
}
