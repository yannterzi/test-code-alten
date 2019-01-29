package com.expedia.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.expedia.example.demo.model.Flight;
import com.expedia.example.demo.repository.FlightRepository;
import com.expedia.example.demo.service.FlightService;
import com.expedia.example.demo.util.TimeUtils;

public class FlightServiceTest {

	private FlightService service;
	
	@Mock
	private FlightRepository repository;
	
	@Before
	public void setup () {
		
		MockitoAnnotations.initMocks(this);
		
		service = new FlightService();
		service.repository = repository;
	}
	
	@Test
	public void testSearchFlight() {
		
		LocalTime searchTime = LocalTime.of(6, 0);
		int searchTimeInMinutes = TimeUtils.getMinutesFromStartOfDay(searchTime);
		
		List<Flight> foundFlights = givenFoundFlights(searchTimeInMinutes-300, searchTimeInMinutes+300, "7:30AM", "8:30AM");
		
		List<Flight> result = service.searchFlight(searchTime);
		
		//for this test, foundFlights and result and the same list instance.
		assertEquals(foundFlights, result);
		
		verify(repository).getFlights(searchTimeInMinutes-300, searchTimeInMinutes+300);		
		
	}
	
	
	@Test
	public void testSearchFlight_endTime_beyond_end_of_day() {
		
		LocalTime searchTime = LocalTime.of(21, 0);
		int searchTimeInMinutes = TimeUtils.getMinutesFromStartOfDay(searchTime);
		
		List<Flight> foundFlights1 = givenFoundFlights(searchTimeInMinutes-300, FlightRepository.ONE_DAY_IN_MINUTES-1, "9:30PM", "11:30PM");
		//need snapshot here, because foundFlights2 will be add to foundFlights1
		List<Flight> foundFlights1Shapshot = new ArrayList<>(foundFlights1);
		
		List<Flight> foundFlights2 = givenFoundFlights(0, 120, "1:30AM", "2:30AM");
		
		List<Flight> result = service.searchFlight(searchTime);
		
		verifyResultEqualsToMergeOf2Lists(result, foundFlights1Shapshot, foundFlights2);
		
		verify(repository).getFlights(searchTimeInMinutes-300, FlightRepository.ONE_DAY_IN_MINUTES-1);	
		verify(repository).getFlights(0, 120);	
		
	}
	
	
	@Test
	public void testSearchFlight_startTime_beyond_start_of_day() {
		
		LocalTime searchTime = LocalTime.of(3, 0);
		int searchTimeInMinutes = TimeUtils.getMinutesFromStartOfDay(searchTime);
		
		List<Flight> foundFlights1 = givenFoundFlights(0, searchTimeInMinutes+300, "9:30PM", "11:30PM");
		List<Flight> foundFlights1Shapshot = new ArrayList<>(foundFlights1);
		
		List<Flight> foundFlights2 = givenFoundFlights(FlightRepository.ONE_DAY_IN_MINUTES-1-120, FlightRepository.ONE_DAY_IN_MINUTES-1, "1:30AM", "2:30AM");
		
		List<Flight> result = service.searchFlight(searchTime);
		
		verifyResultEqualsToMergeOf2Lists(result, foundFlights1Shapshot, foundFlights2);
		
		verify(repository).getFlights(0, searchTimeInMinutes+300);
		verify(repository).getFlights(FlightRepository.ONE_DAY_IN_MINUTES-1-120, FlightRepository.ONE_DAY_IN_MINUTES-1);	
		
	}
	
	
	
	private void verifyResultEqualsToMergeOf2Lists(List<Flight> result, List<Flight> foundList1, List<Flight> foundList2) {
		
		assertEquals(foundList1.size()+foundList2.size(), result.size());
		
		foundList1.stream().forEach(flight->{
			assertTrue(result.contains(flight));
		});
		
	}
	
	
	private List<Flight> givenFoundFlights(int startTimeInMinutes, int endTimeInMinutes, String... departureTimes) {
		
		List<Flight> flights = new ArrayList<>();
		
		for(int i=0;i<departureTimes.length;i++) {
			flights.add(new Flight().withFlight("flight"+i).withDeparture(departureTimes[i]));
		}
		
		when(repository.getFlights(startTimeInMinutes, endTimeInMinutes)).thenReturn(flights);
		
		return flights;
		
	}
	
}
