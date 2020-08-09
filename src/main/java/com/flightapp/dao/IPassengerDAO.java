package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Passenger;

public interface IPassengerDAO extends JpaRepository<Passenger, Integer>{

}
