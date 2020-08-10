package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entities.Passenger;

@Repository
public interface IPassengerDAO extends JpaRepository<Passenger, Integer>{

}
