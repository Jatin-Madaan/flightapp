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
import com.flightapp.dao.IFlightDao;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;
import com.flightapp.service.FlightServiceImpl;
import com.flightapp.service.AddFlightService;
import com.flightapp.service.IAddFlightService;

@RunWith(MockitoJUnitRunner.class)
public class FlightAppAddFlightTest {


	@Mock
	FlightDAO flightdao;
	
	@InjectMocks
	FlightServiceImpl flightService;
	@Test
	public void isFlightIdBlank() {
		Flight flight = new Flight();
		flight.setFlightId(0);
		flight.setCarrierName("Airline");
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(120);
		when(flightdao.addFlight(flight)).thenReturn("fail");
		assertEquals("fail", flightService.addFlight(flight));
		
	}

	@Test
	public void isFlightIdNumeric() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(120);
		when(flightdao.addFlight(flight)).thenReturn("pass");
		assertEquals("pass", flightService.addFlight(flight));
	}

	@Test
	public void isCarrierNameWithBlank() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName(null);
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(120);
		when(flightdao.addFlight(flight)).thenReturn("fail");
		assertEquals("fail", flightService.addFlight(flight));
	}

	@Test
	public void isCarrierNameWithAlphaNumeric() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Air11");
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(120);
		when(flightdao.addFlight(flight)).thenReturn("fail");
		assertEquals("fail", flightService.addFlight(flight));
	}

	@Test
	public void isCarrierNameWithAlphabets() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(120);
		when(flightdao.addFlight(flight)).thenReturn("pass");
		assertEquals("pass", flightService.addFlight(flight));
	}

	@Test
	public void isFlightModelWithBlank() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel(null);
		flight.setSeatCapacity(100);
		when(flightdao.addFlight(flight)).thenReturn("fail");
		assertEquals("fail", flightService.addFlight(flight));
	}

	@Test
	public void isFlightModelWithNumericSpecial() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("123@");
		flight.setSeatCapacity(120);
		when(flightdao.addFlight(flight)).thenReturn("fail");
		assertEquals("fail", flightService.addFlight(flight));
	}

	@Test
	public void isFlightModelWithAlphaNumericSpecial() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(120);
		when(flightdao.addFlight(flight)).thenReturn("pass");
		assertEquals("pass", flightService.addFlight(flight));
	}

	@Test
	public void isSeatCapacityWithBlank() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(0);
		when(flightdao.addFlight(flight)).thenReturn("fail");
		assertEquals("fail", flightService.addFlight(flight));

	}

	@Test
	public void isSeatCapacityWithGreaterThan300() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(450);
		when(flightdao.addFlight(flight)).thenReturn("fail");
		assertEquals("fail", flightService.addFlight(flight));
	}

	@Test
	public void isSeatCapacityInBetween100To300() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("Airbus A220");
		flight.setSeatCapacity(150);
		when(flightdao.addFlight(flight)).thenReturn("pass");
		assertEquals("pass", flightService.addFlight(flight));

	}
	

}
