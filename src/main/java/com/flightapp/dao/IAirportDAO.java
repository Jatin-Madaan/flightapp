package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entities.Airport;

/**
 * @author Jatin
 *
 */
@Repository
public interface IAirportDAO extends JpaRepository<Airport, Integer> {

}
