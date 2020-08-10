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
		booking.setBookingId(897);
		when(dao.getBookingByIdAdmin(897)).thenReturn("Test case Passed");
		assertThat(service.getBookingByIdAdmin(897),is("Test case Passed"));
	}
	
	@Test
	public void isBookingIdInvalid() 
	{
		Booking booking = new Booking();
		booking.setBookingId(79);
		when(dao.getBookingByIdAdmin(null)).thenReturn("Test case failed");
		assertThat(service.getBookingByIdAdmin(null),is("Test case failed"));
	}
	
	@Test
	public void isBookingByFlightValid() 
	{
		Booking booking = new Booking();
		booking.setBookingId(6996);
		when(dao.getBookingByFlightAdmin("IG6996")).thenReturn("Test case failed");
		assertThat(service.getBookingByFlightAdmin("IG6996"),is("Test case failed"));
	}
	
	@Test
	public void isBookingByFlightInvalid() 
	{
		Booking booking = new Booking();
		booking.setBookingId(213);
		when(dao.getBookingByIdAdmin(null)).thenReturn("Test case failed");
		assertThat(service.getBookingByIdAdmin(null),is("Test case failed"));
	}
}
