/**
 *   Interface for viewing, removing and rescheduling
 */
package com.flightapp.service;

import java.util.List;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.RescheduleException;

/**
 * Description: Declaring functions: 
 * for getting list of all ScheduleFLight, 
 * deleting a particular ScheduleFLight via known ID, 
 * and rescheduling any current schedule via Id.
 * @author YashYo
 */


public interface IRescheduleAndDeleteService 
{
	public List<ScheduleFlight> viewAllFlightSchedules();
	public void removeFlightById(int scheduleFlightId) throws RescheduleException;
	public ScheduleFlight rescheduleFlightSchedule(int rescheduleId, ScheduleFlight updatedSchedule) throws RescheduleException;
}
