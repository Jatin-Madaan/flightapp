package com.flightapp.junit;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.flightapp.entities.Flight;
import com.flightapp.exception.NoFlightIdException;
import com.flightapp.service.IAddFlightService;


@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class FlightAppAddFlightTest {
	@Autowired
	IAddFlightService addFlightService;

	@Test
	public void getFlightByIdTest() throws NoFlightIdException {
		Flight flight = addFlightService.fetchByFlightId(6666);
		assertEquals(6666, flight.getFlightId());
	}
    
	@Test
	public void addFlightTest() throws NoFlightIdException {
		Flight flight = new Flight(6666, "Spicejet", "Bioing 330", 130);
		assertNotNull(addFlightService.save(flight));
	}

	@Test(expected = NoFlightIdException.class)
	public void NoFlightByException() throws NoFlightIdException {
		addFlightService.fetchByFlightId(000);
	}
	
//	@Test
//	public void removeFlight() throws NoFlightIdException {
//
//		assertEquals("DELETED", addFlightService.deleteById(6666));
//
//	}
}
