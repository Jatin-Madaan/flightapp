package com.flightapp.exception;

public class NoFlightsAvaliableException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public NoFlightsAvaliableException(String str) {
		super(str);
		
	}

}
