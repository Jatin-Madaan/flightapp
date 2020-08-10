package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Schedule;

public interface IScheduleDAO extends JpaRepository<Schedule, Integer>{

}
