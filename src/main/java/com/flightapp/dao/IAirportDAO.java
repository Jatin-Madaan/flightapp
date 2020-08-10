package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Airport;

public interface IAirportDAO extends JpaRepository<Airport, Integer> {

}
