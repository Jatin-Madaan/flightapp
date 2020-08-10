package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entities.Schedule;

@Repository
public interface IScheduleDAO extends JpaRepository<Schedule, Integer>{

}
