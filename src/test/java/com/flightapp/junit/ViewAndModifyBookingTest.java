package com.flightapp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.BookingException;
import com.flightapp.service.IScheduleService;
import com.flightapp.service.IViewAndModifyBookingService;

// Junit testing for the flight app

@SpringBootTest
public class ViewAndModifyBookingTest {

	// Injecting service class to perfomr the tests
	
	@Autowired
	IViewAndModifyBookingService bookingService;
	
	@Autowired
	IScheduleService scheduleService;

	// testing list of booking service
	@Test
	public void listBookingTest() throws BookingException{
		List<Booking> booking=bookingService.viewBookings(200002);
		assertEquals(200002, booking.get(0).getUser().getUserId());
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
		Booking booking=bookingService.cancelBooking(103);
		assertEquals("Cancelled",booking.getBookingStatus());
	}
	
	//wrong booking id provided for cancel booking test
	
	@Test
	public void cancelBookingTest2() throws BookingException{
		assertThrows(BookingException.class,()->{
			bookingService.cancelBooking(32432434);
		});
	}
	
	//test for modifying a booking already done
	
	@Test
	public void modifyBookingTest() throws BookingException{
		Schedule schedule=new Schedule();
		Booking booking=bookingService.modifyBooking(103, schedule);
		assertEquals(103,booking.getBookingId());
	}
	
	//wrong booking id provided for modify booking test
	
	@Test
	public void modifyBookingTest2() throws BookingException{
		Schedule schedule=new Schedule();
		assertThrows(BookingException.class,()->{
			bookingService.modifyBooking(32432434,schedule);
		});
	}
}