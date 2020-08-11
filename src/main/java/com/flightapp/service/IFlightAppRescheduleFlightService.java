/**
 *   Interface for viewing, removing and rescheduling
 */
package com.flightapp.service;


import java.sql.Timestamp;
import java.util.List;
import com.flightapp.entities.ScheduleFlight;

/**
 * @author YashYo
 *
 */


public interface IFlightAppRescheduleFlightService
{
	public List<ScheduleFlight> viewAllFlightSchedules();
	public String removeFlightById(int id);
	public String rescheduleFlightSchedule(ScheduleFlight reschedule, Timestamp arrivalTime, Timestamp departureTime);
}
