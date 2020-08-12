package com.flightapp.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Booking;
import com.flightapp.exception.ErrorInfo;
import com.flightapp.exception.PaymentAndInvoiceExceptionHandler;
import com.flightapp.service.IPaymentAndInvoiceService;

@SpringBootTest
class PaymentAndInvoiceJunitTest {
	
	@Autowired
	IPaymentAndInvoiceService paymentAndInvoiceService;

	@Test
	void GetBookingByIdTest() throws Exception {
		Booking booking = paymentAndInvoiceService.getBookingById(103);
		assertEquals(103, booking.getBookingId());
	}
	
	@Test
	void WhenAlreadyCancelledTest() throws Exception {
		int i = paymentAndInvoiceService.setBookingStatusById(103,200002,"Cancelled",2000L);
		assertEquals(-1,i);
	}
	
	@Test
	void WhenAlreadyBookedTest() throws Exception {
		int i = paymentAndInvoiceService.setBookingStatusById(104,200002,"Payment Success",2000L);
		assertEquals(0,i);
	}

}
