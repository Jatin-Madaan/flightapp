package com.flightapp.exception;

public class NoFlightIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public NoFlightIdException(String message)
{
	super(message);
}
public NoFlightIdException()
{
}
}
