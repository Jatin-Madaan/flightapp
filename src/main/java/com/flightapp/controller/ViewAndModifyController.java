package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Booking;
import com.flightapp.entities.Schedule;
import com.flightapp.service.IViewAndModifyService;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class ViewAndModifyController {
	
	@Autowired
	IViewAndModifyService service;
	
	@GetMapping(value="/bookings/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Booking>> viewBooking(@PathVariable int userId){
		List<Booking> booking=service.viewBookings(userId);
		return new ResponseEntity<List<Booking>>(booking,HttpStatus.OK);
	}
	
	@GetMapping(value="/cancelBooking/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable int bookingId) {
		return new ResponseEntity<Booking>(service.cancelBooking(bookingId),HttpStatus.OK);
	}
	
	@PutMapping(value="/modifyBookings/{bookingId}")
	public ResponseEntity<Booking> modifyBooking(@PathVariable int bookingId,@RequestBody Schedule schedule) {
		return new ResponseEntity<Booking>(service.modifyBooking(bookingId, schedule),HttpStatus.OK);
	}
}
