package com.flightapp.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import com.flightapp.dao.IFlightDao;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.NoFlightIdException;
import com.flightapp.service.IAddFlightService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FlightAppAddFlightTest {
	@Autowired
	IAddFlightService addFlightService;

	@Test
	public void getFlightByIdTest() throws NoFlightIdException {
		Flight flight = addFlightService.fetchByFlightId(7777);
		assertEquals(7777, flight.getFlightId());
	}

	@Test
	public void addFlightTest() throws NoFlightIdException {
		Flight flight = new Flight(8888, "Spicejet", "Bioing 330", 130);
		assertNotNull(addFlightService.save(flight));
	}

	@Test(expected = NoFlightIdException.class)
	public void NoFlightByException() throws NoFlightIdException {
		addFlightService.fetchByFlightId(000);
	}

	@Test
	public void deleteFlight() throws NoFlightIdException {

		assertEquals("DELETED", addFlightService.deleteById(8888));

	}
}
