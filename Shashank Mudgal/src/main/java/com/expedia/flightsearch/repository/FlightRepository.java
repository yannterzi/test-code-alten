package com.expedia.flightsearch.repository;

import java.util.Collection;

import com.expedia.flightsearch.model.Flight;

/**
 * The Interface FlightRepository.
 */
public interface FlightRepository {


	
	/**
	 * Flight by time.
	 * Considers the current date i.e. Today's date
	 *
	 * @param time the time
	 * @return the collection
	 */
	public Collection<Flight> flightByTime(String time);
	
}
