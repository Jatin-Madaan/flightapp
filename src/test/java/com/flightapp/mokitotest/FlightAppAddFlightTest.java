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
public class FlightAppAddFlightTest {

	@Mock
	FlightDAO dao;
	
	@InjectMocks
	FlightServiceImpl service;
	
	@Test
	public void isFlightIdBlank() {
		Flight flight = new Flight();
		flight.setFlightId(0);
		flight.setCarrierName("Airline");
		flight.setFlightModel("AI302/1");
		flight.setSeatCapacity(120);
		when(dao.addFlight(flight)).thenReturn("Test case failed");
		assertThat(service.addFlight(flight),is("Test case failed"));
		}
		
	@Test
	public void isFlightIdMorethan5Digits() {
		Flight flight = new Flight();
		flight.setFlightId(654321);
		flight.setCarrierName("Airline");
		flight.setFlightModel("AI302/1");
		flight.setSeatCapacity(120);
		when(dao.addFlight(flight)).thenReturn("Test case failed");
		assertThat(service.addFlight(flight),is("Test case failed"));
		}
		
	@Test
	public void isFlightId5Digits() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("AI302/1");
		flight.setSeatCapacity(120);
		when(dao.addFlight(flight)).thenReturn("Test case passed");
		assertThat(service.addFlight(flight),is("Test case passed"));
		}
		
	@Test
	public void isCarrierNameWithBlank() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName(null);
		flight.setFlightModel("Boieng 747");
		flight.setSeatCapacity(120);
		when(dao.addFlight(flight)).thenReturn("Test case failed");
		assertThat(service.addFlight(flight),is("Test case failed"));
		}
	@Test
	public void isCarrierNameWithAlphaNumeric() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Air11");
		flight.setFlightModel("Boieng 747");
		flight.setSeatCapacity(120);
		when(dao.addFlight(flight)).thenReturn("Test case failed");
		assertThat(service.addFlight(flight),is("Test case failed"));
		}
	@Test
	public void isCarrierNameWithAlphabets() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("Boieng 747");
		flight.setSeatCapacity(120);
		when(dao.addFlight(flight)).thenReturn("Test case passed");
		assertThat(service.addFlight(flight),is("Test case passed"));
		}
	@Test
	public void isFlightModelWithBlank() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel(null);
		flight.setSeatCapacity(100);
		when(dao.addFlight(flight)).thenReturn("Test case failed");
		assertThat(service.addFlight(flight),is("Test case failed"));
		}

		
	@Test 
	public void isFlightModelWithNumericSpecial() { Flight flight = new
		  Flight(); flight.setFlightId(12345); flight.setCarrierName("Airline");
		  flight.setFlightModel("123@"); flight.setSeatCapacity(120);
		  when(dao.addFlight(flight)).thenReturn("Test case failed");
		  assertThat(service.addFlight(flight),is("Test case failed")); }
		 
	@Test
	public void isFlightModelWithAlphaNumericSpecial() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("AI-123/1");
		flight.setSeatCapacity(120);
		when(dao.addFlight(flight)).thenReturn("Test case passed");
		assertThat(service.addFlight(flight),is("Test case passed"));
		}
	@Test
	public void isSeatCapacityWithBlank() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("AI-123/1");
		flight.setSeatCapacity(0);
		when(dao.addFlight(flight)).thenReturn("Test case failed");
		assertThat(service.addFlight(flight),is("Test case failed"));
		
		}
		@Test
	public void isSeatCapacityWithGreaterThan300() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("AI-123/1");
		flight.setSeatCapacity(450);
		when(dao.addFlight(flight)).thenReturn("Test case failed");
		assertThat(service.addFlight(flight),is("Test case failed"));
		}
		@Test
	public void isSeatCapacityInBetween100To300() {
		Flight flight = new Flight();
		flight.setFlightId(12345);
		flight.setCarrierName("Airline");
		flight.setFlightModel("AI-123/1");
		flight.setSeatCapacity(150);
		when(dao.addFlight(flight)).thenReturn("Test case passed");
		assertThat(service.addFlight(flight),is("Test case passed"));
		
		}

	

}
