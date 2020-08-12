package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Booking;
import com.flightapp.entities.Flight;
import com.flightapp.entities.Schedule;

@Service
public class FlightServiceImpl implements IFlightService{

	private FlightDAO dao;
	
	public FlightServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public FlightServiceImpl(FlightDAO dao) {
		this.dao=dao;
	}

	@Override
	public String scheduleFlight(int availableSeats, Flight flight, Schedule schedule) {
		return dao.scheduleFlight(availableSeats, flight, schedule);
	}

	@Override
	public String addFlight(Flight flight) {
		return dao.addFlight(flight);
	}

	@Override
	public String modifySchedule(Schedule schedule) {
		return dao.modifySchedule(schedule);
	}

	@Override
	public Booking getbookingbyid(int bookingid, int userid) {
		Booking bookingdetails = dao.getbookingbyid(bookingid);
		if (bookingdetails.getUser().getUserId() == userid) {
			System.out.println(bookingdetails.getUser().getUserId());

			return bookingdetails;
		} else {
			return null;
		}
	}

	@Override
	public String getBookingByIdAdmin(Integer bookingId) {
		return dao.getBookingByIdAdmin(bookingId);
	}

	@Override
	public String getBookingByFlightAdmin(String flightId) {
		return dao.getBookingByFlightAdmin(flightId);
	}

	@Override
	public int setbookingstatusbyid(int bookingid, String status, int securitynumber, int amount) {
		Booking bookingdetails = dao.setbookingstatusbyid(bookingid);
		String status_before = bookingdetails.getBookingStatus();
		if (status_before.equals("Failed")) {
			return -1;
		}
		if (status_before.contentEquals(status)) {
			return 0;
		} else {
			bookingdetails.setBookingStatus(status);
			return 1;
		}
	}

	@Override
	public List<Booking> viewBookings(int userId) {
		return dao.viewBookings(userId);
	}

	@Override
	public Booking cancelBooking(int bookingId) {
		return dao.cancelBooking(bookingId);
	}

	@Override
	public Booking modifyBooking(int bookingId, Schedule schedule) {
		return dao.modifyBooking(bookingId, schedule);

	}
}
