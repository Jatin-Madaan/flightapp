package com.flightapp.service;

import org.springframework.stereotype.Service;

import com.flightapp.entities.Booking;

@Service
public interface IPaymentAndInvoiceService {
	
	public Booking getbookingbyid(int bookingid) throws Exception;
	
	public int setbookingstatusbyid(int bookingid,int userid, String status,long amount) throws Exception;

}
