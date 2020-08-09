package com.flightapp.mokitotest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Passenger;
import com.flightapp.entities.Schedule;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.entities.User;
import com.flightapp.service.FlightServiceImpl;



@RunWith(MockitoJUnitRunner.class)
class PaymentAndInvoiceTest {
	
	FlightDAO dao = Mockito.mock(FlightDAO.class);
	
	FlightServiceImpl c = new FlightServiceImpl(dao);
	
	LocalDateTime now = LocalDateTime.now();  
	
	LocalTime myObj = LocalTime.now();
	
	Date date = new Date();

	@Test
	void setbookingstatusbyidtest() {
		Flight flight  = new Flight();
		flight.setFlightId(1);
		flight.setCarrierName("Indigo");
		flight.setFlightModel("CEO");
		flight.setSeatCapacity(150);
		Airport airport1 = new Airport();
		airport1.setAirportId(1);
		airport1.setAddress("Coimbatore");
		airport1.setAirportName("CBE");
		Airport airport2 = new Airport();
		airport2.setAirportId(2);
		airport2.setAddress("Chennai");
		airport2.setAirportName("MDS");
		Schedule schedule = new Schedule();
		schedule.setDestinationAirport(airport2);
		schedule.setSourceAirport(airport1);
		schedule.setDepartureTime(LocalDateTime.now());
		schedule.setArrivalTime(LocalDateTime.of(2020, 2, 13, 15, 56));
		ScheduleFlight scheduleflight = new ScheduleFlight();
		scheduleflight.setFlight(flight);
		scheduleflight.setSchedule(schedule);
		scheduleflight.setAvailableSeats(148);
		User user  = new User();
		user.setEmail("prithve01234@gmail.com");
		user.setGender("Male");
		user.setPassword("prithve");
		user.setPhone("9500332672");
		user.setUserId(1);
		user.setUserName("Prithve Kumar");
		user.setUserRole("Customer");
		user.setUserState("Active");
		Booking booking  = new Booking();
		booking.setBookingId(1);
		Passenger passenger1 = new Passenger();
		passenger1.setAge(45);
		passenger1.setBooking(booking);
		passenger1.setLuggage("15kg");
		passenger1.setPassengerName("Palaniswamy K");
		passenger1.setPnrNumber(1);
		passenger1.setSeatNumber("1A");
		passenger1.setTravelClass("Business Class");
		Passenger passenger2 = new Passenger();
		passenger2.setAge(45);
		passenger2.setBooking(booking);
		passenger2.setLuggage("15kg");
		passenger2.setPassengerName("Palaniswamy K");
		passenger2.setPnrNumber(1);
		passenger2.setSeatNumber("1A");
		passenger2.setTravelClass("Business Class");
		booking.setBookingDate(date);
		booking.setBookingStatus("Payment Success");
		booking.setBookingTime(null);
		booking.setFlight(flight);
		booking.setNoOfPassenger(2L);
		Set<Passenger> p1 = new HashSet<Passenger>();
		p1.add(passenger1);
		p1.add(passenger2);
		booking.setPassengers(p1);
		booking.setScheduleFlight(scheduleflight);
		booking.setTicketPrice(220000L);
		booking.setUser(user);
		
		when(dao.setbookingstatusbyid("1")).thenReturn(booking);
		assertEquals(0, c.setbookingstatusbyid("1","Payment Success"));
		
	}
	
	
	@Test
	void getbookingbyidtest() {
		Flight flight  = new Flight();
		flight.setFlightId(1);
		flight.setCarrierName("Indigo");
		flight.setFlightModel("CEO");
		flight.setSeatCapacity(150);
		Airport airport1 = new Airport();
		airport1.setAirportId(1);
		airport1.setAddress("Coimbatore");
		airport1.setAirportName("CBE");
		Airport airport2 = new Airport();
		airport2.setAirportId(2);
		airport2.setAddress("Chennai");
		airport2.setAirportName("MDS");
		Schedule schedule = new Schedule();
		schedule.setDestinationAirport(airport2);
		schedule.setSourceAirport(airport1);
		schedule.setDepartureTime(LocalDateTime.now());
		schedule.setArrivalTime(LocalDateTime.of(2020, 2, 13, 15, 56));
		ScheduleFlight scheduleflight = new ScheduleFlight();
		scheduleflight.setFlight(flight);
		scheduleflight.setSchedule(schedule);
		scheduleflight.setAvailableSeats(148);
		User user  = new User();
		user.setEmail("prithve01234@gmail.com");
		user.setGender("Male");
		user.setPassword("prithve");
		user.setPhone("9500332672");
		user.setUserId(1);
		user.setUserName("Prithve Kumar");
		user.setUserRole("Customer");
		user.setUserState("Active");
		Booking booking  = new Booking();
		booking.setBookingId(1);
		Passenger passenger1 = new Passenger();
		passenger1.setAge(45);
		passenger1.setBooking(booking);
		passenger1.setLuggage("15kg");
		passenger1.setPassengerName("Palaniswamy K");
		passenger1.setPnrNumber(1);
		passenger1.setSeatNumber("1A");
		passenger1.setTravelClass("Business Class");
		Passenger passenger2 = new Passenger();
		passenger2.setAge(45);
		passenger2.setBooking(booking);
		passenger2.setLuggage("15kg");
		passenger2.setPassengerName("Palaniswamy K");
		passenger2.setPnrNumber(1);
		passenger2.setSeatNumber("1A");
		passenger2.setTravelClass("Business Class");
		booking.setBookingDate(date);
		booking.setBookingStatus("Payment Success");
		booking.setBookingTime(null);
		booking.setFlight(flight);
		booking.setNoOfPassenger(2L);
		Set<Passenger> p1 = new HashSet<Passenger>();
		p1.add(passenger1);
		p1.add(passenger2);
		booking.setPassengers(p1);
		booking.setScheduleFlight(scheduleflight);
		booking.setTicketPrice(220000L);
		booking.setUser(user);
		
		when(dao.getbookingbyid("1")).thenReturn(booking);
		assertEquals(booking,c.getbookingbyid("1",1));
		
	}

}
