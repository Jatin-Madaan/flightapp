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
import com.flightapp.exception.BookingException;
import com.flightapp.service.IViewAndModifyBookingService;

@SpringBootTest
public class ViewAndModifyBookingTest {

	@Autowired
	IViewAndModifyBookingService bookingService;
	
	@Test
	public void listBookingTest() throws BookingException{
		List<Booking> booking=bookingService.viewBookings(200002);
		assertEquals(200002, booking.get(0).getUser().getUserId());
	}
	
	@Test
	public void listBookingTest2() throws BookingException{
		assertThrows(BookingException.class,()->{
			bookingService.viewBookings(32432434);
		});
	}
	
	@Test
	public void cancelBookingTest() throws BookingException{
		Booking booking=bookingService.cancelBooking(104);
		assertEquals("Cancelled",booking.getBookingStatus());
	}
	
	@Test
	public void cancelBookingTest2() throws BookingException{
		assertThrows(BookingException.class,()->{
			bookingService.cancelBooking(32432434);
		});
	}
	
	@Test
	public void modifyBookingTest() throws BookingException{
		Schedule schedule=new Schedule();
		Booking booking=bookingService.modifyBooking(102, schedule);
		assertEquals(102,booking.getBookingId());
	}
	
	@Test
	public void modifyBookingTest2() throws BookingException{
		Schedule schedule=new Schedule();
		assertThrows(BookingException.class,()->{
			bookingService.modifyBooking(32432434,schedule);
		});
	}
}