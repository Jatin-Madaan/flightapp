package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.ScheduleFlight;

public interface IScheduleFlightDAO extends JpaRepository<ScheduleFlight, Integer>{

}
