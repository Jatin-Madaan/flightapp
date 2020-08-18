package com.flightapp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Booking;
import com.flightapp.exception.BookingException;
import com.flightapp.service.IViewAndModifyBookingService;

// Junit testing for the flight app

@SpringBootTest
public class ViewAndModifyBookingTest {

	// Injecting service class to perform the tests
	
	@Autowired
	IViewAndModifyBookingService bookingService;
	

	// testing list of booking service
	@Test
	public void listBookingTest() throws BookingException{
		List<Booking> booking=bookingService.viewBookings(10001);
		assertEquals(10001, booking.get(0).getUser().getUserId());
	}
	
	//list of booking when wrong id is provided
	
	@Test
	public void listBookingTest2() throws BookingException{
		assertThrows(BookingException.class,()->{
			bookingService.viewBookings(32432434);
		});
	}
	
	// canceling a booking  by user test
	@Test
	public void cancelBookingTest() throws BookingException{
		//Booking booking=bookingService.cancelBooking(108);
		//assertEquals("Cancelled",booking.getStatus());
	}
	
	//wrong booking id provided for cancel booking test
	
	@Test
	public void cancelBookingTest2() throws BookingException{
		assertThrows(BookingException.class,()->{
			bookingService.cancelBooking(32432434);
		});
	}
}