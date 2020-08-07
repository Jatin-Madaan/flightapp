package com.flightapp.mokitotest;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.flightapp.dao.FlightDAO;
import com.flightapp.entities.Airport;
import com.flightapp.entities.Schedule;
import com.flightapp.service.FlightServiceImpl;
@RunWith(MockitoJUnitRunner.class)
class FlightAppRescheduleTest 
{
	
	FlightDAO dao = Mockito.mock(FlightDAO.class);
	
	FlightServiceImpl service = new FlightServiceImpl(dao);
	
	@Test
	public void isNull() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(null);
		schedule.setArrivalTime(null);	
		
		when(dao.modifySchedule(schedule)).thenReturn("wrong");
		String msg = service.modifySchedule(schedule);
		//assertEquals(msg,"wrong");
		assertThat(msg, is("wrong"));
	}
	
	@Test
	public void isDeprtTimeInvalid() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(LocalDateTime.of(2020, 10, 1, 14, 00));
		schedule.setArrivalTime(LocalDateTime.now());	
		
		when(dao.modifySchedule(schedule)).thenReturn("wrong");
		String msg = service.modifySchedule(schedule);
		assertThat(msg, is("wrong"));
	}
	
	@Test
	public void isDeprtTimeValid() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(LocalDateTime.now());
		schedule.setArrivalTime(LocalDateTime.of(2020, 10, 1, 15, 00));	
		
		when(dao.modifySchedule(schedule)).thenReturn("ok");
		String msg = service.modifySchedule(schedule);
		assertThat(msg, is("ok"));
	}
	
	@Test
	public void isNotNullValid() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(LocalDateTime.of(2020, 10, 1, 14, 00));
		schedule.setArrivalTime(LocalDateTime.of(2020, 10, 1, 15, 00));	
		
		when(dao.modifySchedule(schedule)).thenReturn("ok");
		String msg = service.modifySchedule(schedule);
		assertThat(msg, is("ok"));
	}
	
	@Test
	public void isNotNullButInvalid() 
	{
		Schedule schedule = new Schedule();
		Airport dest = new Airport();
		dest.setAddress("Delhi");
		Airport source = new Airport();
		source.setAddress("Mumbai");
		schedule.setDestinationAirport(dest);
		schedule.setSourceAirport(source);

		schedule.setDepartureTime(LocalDateTime.of(2020, 10, 1, 15, 00));
		schedule.setArrivalTime(LocalDateTime.of(2020, 10, 1, 14, 00));	
		
		when(dao.modifySchedule(schedule)).thenReturn("wrong");
		String msg = service.modifySchedule(schedule);
		assertThat(msg, is("wrong"));
	}
}
