package com.expedia.flightsearch.service;

import java.util.Collection;
import java.util.Date;

import com.expedia.flightsearch.model.Flight;

/**
 * The Interface FlightService.
 */
public interface FlightService {

	
	/**
	 * Flights by time.
	 * Queries flights from 5 hours prior to the time and 
	 * until 5 hours later on the current date.
	 *
	 * @param time the time
	 * @return the collection
	 */
	public Collection<Flight> flightsByTime(String time);
	
}
