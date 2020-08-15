package com.flightapp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Airport;
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
		
		Airport dest = new Airport();
		dest.setAddress("Pune");
		Airport source = new Airport();
		source.setAddress("Goa");
		
		Schedule schedule=new Schedule();
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);
		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 15, 00)));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 16, 20)));
		
		Booking booking=bookingService.modifyBooking(103, schedule);
		assertEquals(103,booking.getBookingId());
	}
	
	//wrong booking id provided for modify booking test
	
	@Test
	public void modifyBookingTest2() throws BookingException{
		
		Airport dest = new Airport();
		dest.setAddress("Pune");
		Airport source = new Airport();
		source.setAddress("Goa");
		
		Schedule schedule=new Schedule();
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);
		schedule.setDepartureTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 15, 00)));
		schedule.setArrivalTime(Timestamp.valueOf(LocalDateTime.of(2020, 2, 13, 16, 20)));
		
		assertThrows(BookingException.class,()->{
			bookingService.modifyBooking(32432434,schedule);
		});
	}
}