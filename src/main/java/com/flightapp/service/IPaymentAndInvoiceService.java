package com.flightapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Passenger;

@Service
@Transactional
public interface IPaymentAndInvoiceService {
	
	public Booking getBookingById(int bookingid) throws Exception;
	
	public int setBookingStatusById(int bookingid,int userid, String status,long amount) throws Exception;
	
	public Passenger getpassengerdetails(int pnr);


}
