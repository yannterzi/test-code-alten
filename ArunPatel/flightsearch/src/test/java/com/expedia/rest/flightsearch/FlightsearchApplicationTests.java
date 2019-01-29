package com.expedia.rest.flightsearch;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.expedia.rest.flightsearch.domain.Flight;
import com.expedia.rest.flightsearch.exception.InvalidSearchCriteriaException;
import com.expedia.rest.flightsearch.service.FlightService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightsearchApplicationTests {

	@Autowired
	FlightService flightService;
	
	@Test
	public void testFlightSearch() throws InvalidSearchCriteriaException {
		List<Flight> flight6am = flightService.fetchFlights("6AM");
		assertEquals(flight6am.size(),2);
		
		List<Flight> flight5am = flightService.fetchFlights("5AM");
		assertEquals(flight5am.size(),1);

		List<Flight> flight2am = flightService.fetchFlights("2AM");
		assertEquals(flight2am.size(),0);

		List<Flight> flight3pm = flightService.fetchFlights("3PM");
		assertEquals(flight3pm.size(),3);
		
		List<Flight> flight1am = flightService.fetchFlights("1AM");
		assertEquals(flight1am.size(),0);
	}	

}

