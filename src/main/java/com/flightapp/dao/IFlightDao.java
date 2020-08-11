package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entities.Flight;

@Repository
public interface IFlightDao extends JpaRepository<Flight, Integer>{


}
