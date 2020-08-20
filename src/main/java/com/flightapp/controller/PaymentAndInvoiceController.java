package com.flightapp.controller;

import java.util.List;

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
import com.flightapp.entities.Passenger;
import com.flightapp.service.IPaymentAndInvoiceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "*")
public class PaymentAndInvoiceController {
	
	Logger logger = LoggerFactory.getLogger(PaymentAndInvoiceController.class);

	@Autowired
	IPaymentAndInvoiceService paymentAndInvoiceService;
	
	/** Method: getbookingbyid
	 * Description: get the booking details.
	 * @param bookingid: Bookingid of the booking
	 * @return Booking object: It returns an object of booking table
	 * @author Prithve
	 */
	@GetMapping(path="/getbookingbyid/{bookingid}")
	public Booking GetBookingById(@PathVariable int bookingid) throws Exception{
		logger.info("Getting the details from frontend for getbookingbyid function");
		return paymentAndInvoiceService.getBookingById(bookingid);

		
	}
	
	/** Method: setbookingstatusbyid
	 * Description: Set the booking status.
	 * @param bookingid: Bookingid of the booking
	 * @param userid: Userid of the booking
	 * @param status: status of the booking
	 * @param amount: amount of the booking
	 * @return int: It returns conformation status
	 * @author Prithve
	 */
	@GetMapping(path="/setbookingstatusbyid/{bookingid}/{userid}/{status}/{amount}")
	public int SetBookingStatusById(@PathVariable int bookingid,@PathVariable int userid,@PathVariable String status,@PathVariable long amount) throws Exception {
		logger.info("Getting the details from frontend for setbookingstatusbyid function");
		return paymentAndInvoiceService.setBookingStatusById(bookingid, userid, status, amount);
	}
	
	@GetMapping(path="/getpassengerdetails/{pnr}")
	public Passenger getpassengerdetails(@PathVariable int pnr){
		return paymentAndInvoiceService.getpassengerdetails(pnr);
	}

}
