package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.flightapp.entities.Booking;

@Repository
public interface IBookingDAO extends JpaRepository<Booking, Integer>
{ 
	
}
