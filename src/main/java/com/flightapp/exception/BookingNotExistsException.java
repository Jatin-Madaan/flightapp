package com.flightapp.exception;

public class BookingNotExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BookingNotExistsException(String message) {
		super(message);
	}
}
