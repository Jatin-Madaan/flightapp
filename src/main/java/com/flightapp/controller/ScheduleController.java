package com.flightapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Schedule;
import com.flightapp.service.IScheduleService;

/**
 * @author Jatin
 *
 */
@CrossOrigin(origins = "*")
@RestController
@ControllerAdvice
public class ScheduleController {

	@Autowired
	IScheduleService scheduleService;
	
	Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	/**
	 * Method: addSchedule
	 * Description: Adding Schedule obj to table
	 * @param schedule
	 * @return Schedule
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/Schedule/add")
	public Schedule addSchedule(@RequestBody Schedule schedule)  throws Exception{
		logger.info("adding schedule");
		return scheduleService.addSchedule(schedule);
	}
	
	/**
	 * Method: getScheduleById
	 * Description: getting Schedule obj from table by providing id
	 * @param schedule
	 * @return Schedule
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/Schedule/id/{scheduleId}")
	public Schedule getScheduleById(@PathVariable int scheduleId)  throws Exception{
		logger.info("getting Schedule by ID");
		return scheduleService.getScheduleById(scheduleId);
	}
	
	/**
	 * Method: removeSchedule
	 * Description: removing Schedule obj to table
	 * @param schedule
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/Schedule/remove")
	public void removeSchedule(@RequestBody Schedule schedule)  throws Exception {
		logger.info("removing the Schedule");
		scheduleService.removeSchedule(schedule);
	}

	/**
	 * Method: removeSchedule
	 * Description: getting Schedule obj lists from table
	 * @param
	 * @return List<Schedule>
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/Schedule/all")
	public List<Schedule> getAllSchedules() throws Exception{
		logger.info("getting the list of schedules");
		return scheduleService.getAllSchedules();
	}
}
