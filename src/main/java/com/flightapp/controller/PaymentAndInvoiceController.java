package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Booking;
import com.flightapp.service.IPaymentAndInvoiceService;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "*")
public class PaymentAndInvoiceController {
	
	@Autowired
	IPaymentAndInvoiceService service;
	
	@GetMapping(path="/getbookingbyid/{bookingid}")
	public Booking getbookingbyid(@PathVariable int bookingid) {
		return service.getbookingbyid(bookingid);
		
	}
	
	@GetMapping(path="/setbookingstatusbyid/{bookingid}/{userid}/{status}/{amount}")
	public int setbookingstatusbyid(@PathVariable int bookingid,@PathVariable int userid,@PathVariable String status,@PathVariable long amount) {
		return service.setbookingstatusbyid(bookingid, userid, status, amount);
	}

}
