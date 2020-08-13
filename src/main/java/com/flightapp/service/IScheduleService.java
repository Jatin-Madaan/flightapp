package com.flightapp.service;

import java.util.List;
import com.flightapp.entities.Schedule;
import com.flightapp.exception.ScheduleException;

public interface IScheduleService {
	public Schedule addSchedule(Schedule schedule) throws ScheduleException;
	public Schedule getScheduleById(int scheduleId) throws ScheduleException;
	public void removeSchedule(Schedule schedule) throws ScheduleException;
	public List<Schedule> getAllSchedules() throws ScheduleException;
}
