package com.flightapp.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightapp.entities.Booking;
import com.flightapp.exception.BookingException;
import com.flightapp.service.BookingService;
import com.flightapp.dao.IBookingDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddBookingTest 
{
	@Mock
	private IBookingDAO bookingDao;
	
	@InjectMocks
	private BookingService bookingService;
	
	@Test
	public void addBookingTest() throws BookingException {
		
		Booking booking = new Booking();
		booking.setBookingId(1342567342);
		
		//Mocking the dao function
		when(bookingDao.save(booking)).thenReturn(booking);
		try 
		{
			assertEquals("category added", bookingService.addBooking(booking));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	
	}

}
