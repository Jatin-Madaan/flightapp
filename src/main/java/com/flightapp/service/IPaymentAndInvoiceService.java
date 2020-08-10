package com.flightapp.service;

import org.springframework.stereotype.Service;

import com.flightapp.entities.Booking;


public interface IPaymentAndInvoiceService {
	
	public Booking getbookingbyid(int bookingid);
	
	public int setbookingstatusbyid(int bookingid,int userid, String status,long amount);

}
