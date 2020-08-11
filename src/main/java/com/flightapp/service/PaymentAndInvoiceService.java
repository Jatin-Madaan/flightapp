package com.flightapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IBookingDAO;
import com.flightapp.dao.IUserDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.User;




@Service
public class PaymentAndInvoiceService implements IPaymentAndInvoiceService {
	
	@Autowired
	IBookingDAO bookingdao;
	
	@Autowired
	IUserDAO userdao;
	
	/*
	 * Used Logging
	 */
	private static final Logger LOGGER=LoggerFactory.getLogger(PaymentAndInvoiceService.class);

	/*
	 * This function is used to get all the bookingdetails of a booking id
	 * and send back for INVOICE generation.
	 */
	@Override
	public Booking getbookingbyid(int bookingid) throws Exception {
		
		if(bookingdao.existsById(bookingid)) {
			LOGGER.trace("Retrieve the data from booking table based on bookingid");
			Booking bookingdetails = bookingdao.getOne(bookingid);
			LOGGER.trace("Sending back the data");
			return bookingdetails;
		}
		else {
			LOGGER.trace("The bookingid is not found");
			throw new Exception("The bookingid is not found");
		}
	}

	/*
	 * This function is used to set the bookingstatus(Payment Success/Payment Cancelled) and 
	 * balance(reduce ticket amount) in BOOKING_MASTER and USER_MASTER from the PAYMENT page.
	 */
	@Override
	public int setbookingstatusbyid(int bookingid,int userid, String status,long amount) throws Exception {
		if(bookingdao.existsById(bookingid)) {

			Booking bookingdetails = bookingdao.getOne(bookingid);
			LOGGER.trace("Retrieve the data from booking table based on bookingid");
			User userdetails = userdao.getOne(userid);
			LOGGER.trace("Retrieve the data from User table based on userid");
			long balance = userdetails.getBalance();
			String status_before = bookingdetails.getBookingStatus();
			
			if(status_before.equals("Payment Cancelled")) {
				LOGGER.trace("The payment status for this is already cancelled");
				return -1;
			}
			else if(status_before.contentEquals(status)) {
				LOGGER.trace("'The payment status for this is already:"+status);
				return 0;
			}
			else {
				if(balance > amount) {
					if(status.equals("Payment Cancelled")) {
						LOGGER.trace("The satus of booking is updated as: "+status);
						bookingdetails.setBookingStatus(status);
						bookingdao.save(bookingdetails);
						return 1;
					}
					LOGGER.trace("The satus of booking is updated as: "+status);
					bookingdetails.setBookingStatus(status);
					balance = balance - amount;
					userdetails.setBalance(balance);
					bookingdao.save(bookingdetails);
					userdao.save(userdetails);
					return 1;
				}
				
			}
		}
		LOGGER.trace("The bookingid is not found");
		throw new Exception("The bookingid is not found");
	}

}
