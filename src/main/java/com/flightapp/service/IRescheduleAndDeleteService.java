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


public interface IRescheduleAndDeleteService
{
	public List<ScheduleFlight> viewAllFlightSchedules();
	public String removeFlightById(int scheduleFlightId);
	public String rescheduleFlightSchedule(int rescheduleId, Timestamp arrivalTime, Timestamp departureTime);
}
