package com.flightapp.service;

import org.springframework.stereotype.Service;

import com.flightapp.entities.Booking;

@Service
public interface IPaymentAndInvoiceService {
	
	public Booking getBookingById(int bookingid) throws Exception;
	
	public int setBookingStatusById(int bookingid,int userid, String status,long amount) throws Exception;

}
