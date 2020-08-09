package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Booking;

public interface IBookingDAO extends JpaRepository<Booking, Integer>{

}
