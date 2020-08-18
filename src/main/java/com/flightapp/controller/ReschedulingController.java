package com.flightapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.RescheduleException;
import com.flightapp.service.IRescheduleAndDeleteService;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "*")
public class ReschedulingController 
{
	
	@Autowired
	IRescheduleAndDeleteService rescheduleFlightService;
	
	
	/** Method: getSchedulesFlights
	 * Description: get mapping for getting the list of all SchedulesFlight
	 * @return List<ScheduleFlight>: It returns the list of all SchedulesFlight
	 * @author YashYo
	 */
	@GetMapping(path="/admin/scheduleFlight/viewAll")
	public List<ScheduleFlight> getSchedulesFlights() 
	{
		return rescheduleFlightService.viewAllFlightSchedules();
	}
	
	/** Method: removeSchedule
	 * Description: delete mapping for deleting the SchedulesFlight for a given id.
	 * @return string: feedback message.
	 * @author YashYo
	 */
	@DeleteMapping(path="/admin/deleteSchedule/{scheduleFlightId}")
	public void removeSchedule(@PathVariable int scheduleFlightId) throws RescheduleException
	{
		rescheduleFlightService.removeFlightById(scheduleFlightId);
	}
	
	/** Method: rescheduleFlightSchedule
	 * Description: put mapping for rescheduling the SchedulesFlight for a given id.
	 * @return string: feedback message.
	 * @author YashYo
	 */
	@PutMapping(path="/admin/rescheduleFlightSchedule/{rescheduleId}")
	public ScheduleFlight rescheduleFlightSchedule(@PathVariable int rescheduleId, @RequestBody ScheduleFlight updatedScheduled) throws RescheduleException
	{
		return rescheduleFlightService.rescheduleFlightSchedule(rescheduleId,updatedScheduled);
	}
}
