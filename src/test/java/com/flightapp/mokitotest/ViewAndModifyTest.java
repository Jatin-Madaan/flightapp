package com.flightapp.mokitotest;

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
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.entities.User;
import com.flightapp.service.FlightServiceImpl;
import com.flightapp.service.IFlightService;

@RunWith(MockitoJUnitRunner.class)
public class ViewAndModifyTest {
	
	@Mock
	FlightDAO dao;
	
	@InjectMocks
	IFlightService service=new FlightServiceImpl();
	
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
		
		assertEquals(booking1,booking);
	}
	
	@Test
	public void viewBookingsNull() {
		
		when(dao.viewBookings(15)).thenReturn(null);
		List<Booking> booking=new ArrayList<>();
		booking=service.viewBookings(15);
		assertEquals(null,booking);
	}
	
	@Test
	public void cancelBookings() {
		
		Booking booking=new Booking();
		booking.setBookingStatus("Cancelled");
		
		when(dao.cancelBooking(10000)).thenReturn(booking);
		
		Booking res=service.cancelBooking(10000);
		assertEquals(res.getBookingStatus(),booking.getBookingStatus());
	}
	
	@Test
	public void cancelBookingsNull() {
		Booking booking=new Booking();
		booking.setBookingStatus("Success");
		
		when(dao.cancelBooking(1000)).thenReturn(booking);
		
		Booking res=service.cancelBooking(1000);
		assertEquals(res.getBookingStatus(),booking.getBookingStatus());
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
		
		ScheduleFlight scheduleFlight=new ScheduleFlight();
		scheduleFlight.setSchedule(schedule);
		
		Booking booking=new Booking();
		booking.setScheduleFlight(scheduleFlight);
		
		when(dao.modifyBooking(5000, schedule)).thenReturn(booking);
		
		Booking res=service.modifyBooking(5000, schedule);
		assertEquals(res,booking);
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
		
		ScheduleFlight scheduleFlight=new ScheduleFlight();
		scheduleFlight.setSchedule(schedule);
		
		Booking booking=new Booking();
		booking.setScheduleFlight(scheduleFlight);
		
		when(dao.modifyBooking(1000, schedule)).thenReturn(null);
		Booking res=service.modifyBooking(1000, schedule);
		assertEquals(res,null);
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
		
		ScheduleFlight scheduleFlight=new ScheduleFlight();
		scheduleFlight.setSchedule(schedule);
		
		Booking booking=new Booking();
		booking.setScheduleFlight(scheduleFlight);
		
		when(dao.modifyBooking(5000, null)).thenReturn(null);
		Booking res=service.modifyBooking(5000, null);
		assertEquals(res,null);
	}
}