package com.flightapp.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseBody
	 @ResponseStatus(value=HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(value = {Exception.class})
	protected ErrorInfo handleconflict(Exception e,HttpServletRequest req) {
		 String bodyOfResponse = e.getMessage();
		 String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri,bodyOfResponse); 
	 }

}
