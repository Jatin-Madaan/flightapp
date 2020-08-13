package com.flightapp.junit;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Booking;
import com.flightapp.service.IPaymentAndInvoiceService;



@SpringBootTest
class PaymentAndInvoiceTest {
	
	@Autowired
	IPaymentAndInvoiceService paymentAndInvoiceService;

	@Test
	void getbookingbyidtest() throws Exception {
		Booking booking = paymentAndInvoiceService.getBookingById(103);
		assertEquals(103, booking.getBookingId());
	}
	
	
	@Test
	void setbookingstatusbyidtest() throws Exception {
		int i = paymentAndInvoiceService.setBookingStatusById(104,200002,"Cancelled",1200);
		assertEquals(-1,i);
		
	}

}
