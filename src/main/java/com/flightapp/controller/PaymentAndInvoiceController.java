package com.flightapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Booking;
import com.flightapp.service.IPaymentAndInvoiceService;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "*")
public class PaymentAndInvoiceController {

	@Autowired
	IPaymentAndInvoiceService paymentAndInvoiceService;
	
	/*
	 * Get bookingid from INVOICE page and return the booking details.
	*/
	@GetMapping(path="/getbookingbyid/{bookingid}")
	public Booking getbookingbyid(@PathVariable int bookingid) throws Exception{
		return paymentAndInvoiceService.getbookingbyid(bookingid);
		
	}
	
	/*
	 * Get bookingid,userid,status,amount from PAYMENT page and return an integer.
	*/
	@GetMapping(path="/setbookingstatusbyid/{bookingid}/{userid}/{status}/{amount}")
	public int setbookingstatusbyid(@PathVariable int bookingid,@PathVariable int userid,@PathVariable String status,@PathVariable long amount) throws Exception {
		return paymentAndInvoiceService.setbookingstatusbyid(bookingid, userid, status, amount);
	}

}
