package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entities.ScheduleFlight;

@Repository
public interface IScheduleFlightDAO extends JpaRepository<ScheduleFlight, Integer>{

}
