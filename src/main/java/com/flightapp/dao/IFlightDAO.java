package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Flight;

public interface IFlightDAO extends JpaRepository<Flight, Integer>{

}
