package com.flightapp.junit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Booking;
import com.flightapp.service.IAdminBookingCancelService;

@SpringBootTest
public class AdminCancelBookingTest 
{
	@Autowired
	IAdminBookingCancelService bookingCancelService;
	
	@Test
	void CancelBookingValidTest() throws Exception {
		String message = bookingCancelService.cancelBookingById(101);
		System.out.println(message);
		assertEquals(message, "Cancelled succesfully!");
	}
	
	@Test
	void CancelBookingInvalidTest() throws Exception {
		String message = bookingCancelService.cancelBookingById(1234);
		System.out.println(message);
		assertEquals(message, "Error: Cancelling the data which is not present!");
	}
	
	
}
