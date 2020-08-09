package com.flightapp.mokitotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Flight;
import com.flightapp.service.FlightServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AdminCancelBookingTest 
{

	@Mock
	FlightDAO dao;
	
	@InjectMocks
	FlightServiceImpl service;
	
	@Test
	public void isBookingIdValid() 
	{
		Booking booking = new Booking();
		booking.setBookingId("VCLIQR");
		when(dao.getBookingByIdAdmin("VCLIQR")).thenReturn("Test case failed");
		assertThat(service.getBookingByIdAdmin("VCLIQR"),is("Test case failed"));
	}
	
	@Test
	public void isBookingIdInvalid() 
	{
		Booking booking = new Booking();
		booking.setBookingId("VCLIQR");
		when(dao.getBookingByIdAdmin(" ")).thenReturn("Test case failed");
		assertThat(service.getBookingByIdAdmin(" "),is("Test case failed"));
	}
	
	@Test
	public void isBookingByFlightValid() 
	{
		Booking booking = new Booking();
		booking.setBookingId("IG6996");
		when(dao.getBookingByFlightAdmin("IG6996")).thenReturn("Test case failed");
		assertThat(service.getBookingByFlightAdmin("IG6996"),is("Test case failed"));
	}
	
	@Test
	public void isBookingByFlightInvalid() 
	{
		Booking booking = new Booking();
		booking.setBookingId("AI213");
		when(dao.getBookingByIdAdmin(" ")).thenReturn("Test case failed");
		assertThat(service.getBookingByIdAdmin(" "),is("Test case failed"));
	}
}
