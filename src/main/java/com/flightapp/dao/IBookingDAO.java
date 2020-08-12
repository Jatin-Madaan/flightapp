package com.flightapp.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.flightapp.entities.Booking;

@Repository
public interface IBookingDAO extends JpaRepository<Booking, Integer>
{
}
