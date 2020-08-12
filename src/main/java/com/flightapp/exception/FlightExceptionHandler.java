package com.flightapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FlightExceptionHandler {
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<Object> throwException(BookingException exception){
		return new ResponseEntity<Object>(exception.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
	}
}
