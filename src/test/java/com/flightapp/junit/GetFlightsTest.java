package com.flightapp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.service.IGetFlightService;
import com.flightapp.entities.Flight;
import com.flightapp.entities.ScheduleFlight;
import com.flightapp.exception.NoFlightsAvaliableException;

@SpringBootTest
public class GetFlightsTest {
	
	@Autowired
	IGetFlightService getFlightService;
	
	/*Test Case:1  
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest1() throws NoFlightsAvaliableException
	{
		LocalDate time = LocalDate.parse("2020-12-31");
		List<ScheduleFlight> sf = getFlightService.getFlights("Gorakhpur", "Kolkata", time,4);
		boolean test = sf.isEmpty();
		assertEquals(false,test);
	}
	
	/*Test Case:2
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest2() 
	{
		LocalDate time = LocalDate.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights("Hyderabad", "Mumbai", time,4); });
	}
	
	/*Test Case:3
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest3() 
	{
		LocalDate time = LocalDate.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights("Hyderabad", "Hyderabad", time,4); });
	}
	
	/*Test Case:4
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest4() 
	{
		LocalDate time = LocalDate.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights(null, "Mumbai", time,4); });
	}
	
	/*Test Case:5
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest5() 
	{
		LocalDate time = LocalDate.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights("Hyderabad", null, time,4); });
	}

	/*Test Case:6
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest6() 
	{
		LocalDate time = LocalDate.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights(null, null, time,4); });
	}
}
