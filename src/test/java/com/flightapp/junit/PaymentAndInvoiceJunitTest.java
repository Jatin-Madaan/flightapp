package com.flightapp.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entities.Booking;
import com.flightapp.exception.ErrorInfo;
import com.flightapp.exception.GlobalExceptionHandler;
import com.flightapp.service.IPaymentAndInvoiceService;

@SpringBootTest
class PaymentAndInvoiceJunitTest {
	
	@Autowired
	IPaymentAndInvoiceService paymentAndInvoiceService;

	/*
	 * GetBookingById function
	 */
	@Test
	void GetBookingByIdTest() throws Exception {
		Booking booking = paymentAndInvoiceService.getBookingById(103);
		assertEquals(103, booking.getBookingId());
	}
	
	/*
	 * GetBookingById function
	 */
	@Test
	void IfBookingNotFound() throws Exception {
		assertThrows(Exception.class, ()->{ paymentAndInvoiceService.getBookingById(109); });
	}
	
	/*
	 * SetBookingStatusById function
	 */
	@Test
	void WhenAlreadyPaidForBookingTest() throws Exception {
		assertThrows(Exception.class, ()->{ paymentAndInvoiceService.setBookingStatusById(101,10001,"Payment Success",2000L);});
	}
	
	/*
	 * SetBookingStatusById function
	 */
	@Test
	void WhenAlreadyCancelledTheBooking() throws Exception {
		assertThrows(Exception.class, ()->{ paymentAndInvoiceService.setBookingStatusById(103,200002,"Payment Success",2000L);});
	}
	
	/*
	 * SetBookingStatusById function
	 */
	@Test
	void WhenUseridDonotMatchWithBooking() throws Exception {
		assertThrows(Exception.class, ()->{ paymentAndInvoiceService.setBookingStatusById(103,10001,"Payment Success",2000L);});
	}
	
	/*
	 * SetBookingStatusById function
	 */
	@Test
	void WhenUserBalanceIsLow() throws Exception {
		assertThrows(Exception.class, ()->{ paymentAndInvoiceService.setBookingStatusById(106,200002,"Payment Success",2000L);});
	}

}
