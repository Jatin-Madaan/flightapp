package com.flightapp.service;

import java.util.List;

import com.flightapp.entities.Schedule;

public interface IScheduleService {
	public Schedule addSchedule(Schedule schedule) throws Exception;
	public Schedule getScheduleById(int scheduleId) throws Exception;
	public void removeSchedule(Schedule schedule) throws Exception;
	public List<Schedule> getAllSchedules() throws Exception;
}
