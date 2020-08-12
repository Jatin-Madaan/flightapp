package com.flightapp.exception;

public class RescheduleException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	public RescheduleException(String message) 
	{
        super(message);
    }
    public RescheduleException(String message, Throwable cause) 
    {
        super(message, cause);
    }

}
