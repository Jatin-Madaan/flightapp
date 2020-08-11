package com.flightapp.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Booking getbookingbyid(int bookingid) {
		
		if(bookingdao.existsById(bookingid)) {
			Booking bookingdetails = bookingdao.getOne(bookingid);
			System.out.println(bookingdetails);
			return bookingdetails;
		}
		System.out.println("null");
		return null;
	}

	@Override
	public int setbookingstatusbyid(int bookingid,int userid, String status,long amount) {
		if(bookingdao.existsById(bookingid)) {
			Optional<Booking> bookingdetailslist = bookingdao.findById(bookingid);
			Booking bookingdetails = bookingdetailslist.get();
			
			Optional<User> userdetailslist = userdao.findById(userid);
			User userdetails = userdetailslist.get();
			
			long balance = userdetails.getBalance();
			String status_before = bookingdetails.getBookingStatus();
			System.out.println(status_before);
			
			if(status_before.equals("Payment Cancelled")) {
				return -1;
			}
			else if(status_before.contentEquals(status)) {
				return 0;
			}
			else {
				if(balance > amount) {
					bookingdetails.setBookingStatus(status);
					balance = balance - amount;
					userdetails.setBalance(balance);
					bookingdao.save(bookingdetails);
					userdao.save(userdetails);
					return 1;
				}
				
			}
		}
		System.out.println(-2);
		return -2;
	}

}
