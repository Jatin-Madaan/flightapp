package com.flightapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flightapp.exception.NoFlightsAvaliableException;


@ControllerAdvice
public class GetFlightControllerAdvise {
	@ExceptionHandler(NoFlightsAvaliableException.class)
    public final ResponseEntity<String> exceptionHandler(NoFlightsAvaliableException e) 
    {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
