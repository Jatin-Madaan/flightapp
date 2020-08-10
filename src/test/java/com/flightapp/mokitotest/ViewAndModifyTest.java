package com.flightapp.mokitotest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;
import com.flightapp.entities.User;
import com.flightapp.service.FlightServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ViewAndModifyTest {
	
	@Mock
	FlightDAO dao;
	
	@InjectMocks
	FlightServiceImpl service;
	
	@Test
	public void viewBookings() {
		User user=new User();
		user.setUserId(14);
		
		Booking book=new Booking();
		book.setBookingId(101);
		
		Booking book1=new Booking();
		book1.setBookingId(105);
		
		List<Booking> booking=new ArrayList<>();
		booking.add(book);
		booking.add(book1);
		
		when(dao.viewBookings(user.getUserId())).thenReturn(booking);
		
		List<Booking> booking1=new ArrayList<>();
		booking1=service.viewBookings(14);
		
		assertThat(booking1,is(booking));
	}
	
	@Test
	public void viewBookingsNull() {
		
		when(dao.viewBookings(null)).thenReturn(null);
		
		List<Booking> booking=new ArrayList<>();
		booking=service.viewBookings(null);
		
		assertThat(null,is(booking));
	}
	
	@Test
	public void cancelBookings() {
		when(dao.cancelBooking("BK200")).thenReturn(1);
		int res=service.cancelBooking("BK200");
		assertThat(res,is(1));
	}
	
	@Test
	public void cancelBookingsNull() {
		when(dao.cancelBooking(null)).thenReturn(0);
		int res=service.cancelBooking(null);
		assertThat(res,is(0));
	}
	
	@Test
	public void modifyBookings() {
		
		Airport dest = new Airport();
		dest.setAddress("Pune");
		Airport source = new Airport();
		source.setAddress("Goa");
		
		Schedule schedule=new Schedule();
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);
		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 15, 00)));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 16, 20)));
		
		when(dao.modifyBooking("BK100", schedule)).thenReturn(1);
		int res=service.modifyBooking("BK100", schedule);
		assertThat(res,is(1));
	}

	@Test
	public void modifyBookingsNull1() {
		
		Airport dest = new Airport();
		dest.setAddress("Pune");
		Airport source = new Airport();
		source.setAddress("Goa");
		
		Schedule schedule=new Schedule();
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);
		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 15, 00)));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 16, 20)));
		
		when(dao.modifyBooking(null, schedule)).thenReturn(0);
		int res=service.modifyBooking(null, schedule);
		assertThat(res,is(0));
	}
	
	@Test
	public void modifyBookingsNull2() {
		
		Airport dest = new Airport();
		dest.setAddress("Pune");
		Airport source = new Airport();
		source.setAddress("Goa");
		
		Schedule schedule=new Schedule();
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);
		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 15, 00)));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 16, 20)));
		
		when(dao.modifyBooking("BK100", null)).thenReturn(0);
		int res=service.modifyBooking("BK100", null);
		assertThat(res,is(0));
	}
}