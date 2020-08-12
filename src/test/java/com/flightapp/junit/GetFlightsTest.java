package com.flightapp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.service.IGetFlightService;
import com.flightapp.entities.Flight;
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
		LocalDateTime time = LocalDateTime.now();
		List<Flight> sf = getFlightService.getFlights("Hyderabad", "Chennai", time);
		boolean test = sf.isEmpty();
		assertEquals(false,test);
	}
	
	/*Test Case:2
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest2() 
	{
		LocalDateTime time = LocalDateTime.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights("Hyderabad", "Mumbai", time); });
	}
	
	/*Test Case:3
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest3() 
	{
		LocalDateTime time = LocalDateTime.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights("Hyderabad", "Hyderabad", time); });
	}
	
	/*Test Case:4
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest4() 
	{
		LocalDateTime time = LocalDateTime.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights(null, "Mumbai", time); });
	}
	
	/*Test Case:5
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest5() 
	{
		LocalDateTime time = LocalDateTime.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights("Hyderabad", null, time); });
	}

	/*Test Case:6
	 * Description: Searching scheduled flights from given source and destination
	 */
	@Test
	public void GetFlightsTest6() 
	{
		LocalDateTime time = LocalDateTime.now();
		assertThrows(NoFlightsAvaliableException.class, ()->{ getFlightService.getFlights(null, null, time); });
	}
}
