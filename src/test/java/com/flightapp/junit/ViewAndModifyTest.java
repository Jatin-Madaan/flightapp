package com.flightapp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.BookingNotExistsException;
import com.flightapp.service.IViewAndModifyService;

@SpringBootTest
public class ViewAndModifyTest {

	@Autowired
	IViewAndModifyService service;
	
	@Test
	public void listBookingTest() throws BookingNotExistsException{
		List<Booking> booking=service.viewBookings(200002);
		assertEquals(200002, booking.get(0).getUser().getUserId());
	}
	
	@Test
	public void listBookingTest2() throws BookingNotExistsException{
		assertThrows(BookingNotExistsException.class,()->{
			service.viewBookings(32432434);
		});
	}
	
	@Test
	public void cancelBookingTest() throws BookingNotExistsException{
		Booking booking=service.cancelBooking(104);
		assertEquals("Cancelled",booking.getBookingStatus());
	}
	
	@Test
	public void cancelBookingTest2() throws BookingNotExistsException{
		assertThrows(BookingNotExistsException.class,()->{
			service.cancelBooking(32432434);
		});
	}
	
	@Test
	public void modifyBookingTest() throws BookingNotExistsException{
		Schedule schedule=new Schedule();
		Booking booking=service.modifyBooking(102, schedule);
		assertEquals(102,booking.getBookingId());
	}
	
	@Test
	public void modifyBookingTest2() throws BookingNotExistsException{
		Schedule schedule=new Schedule();
		assertThrows(BookingNotExistsException.class,()->{
			service.modifyBooking(32432434,schedule);
		});
	}
}