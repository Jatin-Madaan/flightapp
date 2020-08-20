package com.flightapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.controller.PaymentAndInvoiceController;
import com.flightapp.dao.IBookingDAO;
import com.flightapp.dao.IPassengerDAO;
import com.flightapp.dao.IScheduleFlightDAO;
import com.flightapp.dao.IUserDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Passenger;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.entities.User;


@Service
@Transactional
public class PaymentAndInvoiceService implements IPaymentAndInvoiceService {
	
	@Autowired
	IBookingDAO bookingdao;
	
	@Autowired
	IUserDAO userdao;
	
	@Autowired
	IPassengerDAO passengerdao;
	
	@Autowired
	IScheduleFlightDAO scheduleFlightDao;
	
	Logger LOGGER = LoggerFactory.getLogger(PaymentAndInvoiceService.class);
	
	

	/** Method: getbookingbyid
	 * Description: get the booking details.
	 * @param bookingid: Bookingid of the booking
	 * @return Booking object: It returns an object of booking table
	 * @author Prithve
	 */
	@Override
	public Booking getBookingById(int bookingid) throws Exception {

		
		if(bookingdao.existsById(bookingid)) {
			LOGGER.info("Retrieve the data from booking table based on bookingid for getbookingbyid function");
			Booking bookingdetails = bookingdao.getOne(bookingid);
			LOGGER.info("Sending back the data");
			return bookingdetails;
		}
		else {
			LOGGER.error("The bookingid is not found");
			throw new Exception("The bookingid is not found");
		}
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
	@Override
	@Transactional
	public int setBookingStatusById(int bookingid,int userid, String status,long amount) throws Exception {
			if(bookingdao.existsById(bookingid)) {

			Booking bookingdetails = bookingdao.getOne(bookingid);
			LOGGER.info("Retrieve the data from booking table based on bookingid for setbookingstatusbyid function");
			if(bookingdetails.getUser().getUserId() == userid) {
				
				User userdetails = userdao.getOne(userid);
				LOGGER.info("Retrieve the data from User table based on userid");
				long balance = userdetails.getBalance();
				String status_before = bookingdetails.getBookingStatus();
				
				if(status_before.equals("Payment Cancelled")|| status_before.equals("Cancelled")) {
					LOGGER.info("The payment status for this is already cancelled");
					throw new Exception("The payment is already cancelled ");
				}
				if(status_before.equals("Payment Successful")|| status_before.equals("Successful")) {
					LOGGER.info("The payment status for this is already completed");
					throw new Exception("The payment is already completed ");
				}
				else {
					if(status.equals("Payment Cancelled") || status.equals("Cancelled")) {
						LOGGER.info("The satus of booking is updated as: "+status);
						bookingdetails.setBookingStatus(status);
						bookingdetails.setStatus("Not Booked");
						bookingdao.save(bookingdetails);
						return 1;
					}
					if(balance >= amount) {
						LOGGER.info("The satus of booking is updated as: "+status);
						bookingdetails.setBookingStatus(status);
						bookingdetails.setStatus("Booked");
						balance = balance - amount;
						userdetails.setBalance(balance);
						bookingdao.save(bookingdetails);
						userdao.save(userdetails);
						return 1;
						}
					LOGGER.error("The balance is low");
					throw new Exception("The balance is low,Please contact the customercare service");
					}
					
				}
			LOGGER.error("The Userid is not matching with the booking details");
			throw new Exception("The Userid is not matching with the booking details");	
		}
		LOGGER.error("The bookingid is not found");
		throw new Exception("The bookingid is not found");
	}




	@Override
	public List<Passenger> getpassengerdetails(int bookingid) {
		List<Passenger> listofall =  passengerdao.findAll();
		List<Passenger> passengers = new ArrayList<Passenger>();
		for (Passenger passenger : listofall) {
			if(passenger.getBooking().getBookingId() == bookingid) {
				passengers.add(passenger);
			}
		}
		return passengers;
		
	}

}
