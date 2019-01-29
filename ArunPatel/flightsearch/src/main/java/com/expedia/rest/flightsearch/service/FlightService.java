package com.expedia.rest.flightsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.rest.flightsearch.dao.FlightDao;
import com.expedia.rest.flightsearch.domain.Flight;
import com.expedia.rest.flightsearch.exception.InvalidSearchCriteriaException;
import com.expedia.rest.flightsearch.util.CommonUtility;

/**
 * The FlightService is service which provide the layer between Controller and
 * Repository.
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */

@Service
public class FlightService {

	@Autowired
	FlightDao flightDao;

	/**
	 * fetchFlight method is used to search flight based on the time provided in the
	 * parameter.
	 * 
	 * @param time This is only parameter required to fetch the fligt
	 *             information.Format must be hh:mmAM or hh:mmPM
	 * 
	 * @return It will return the List of flights.
	 * @throws InvalidSearchCriteriaException if parameter is not in proper format.
	 * 
	 */
	public List<Flight> fetchFlights(String time) throws InvalidSearchCriteriaException {

		return flightDao.fetchFlights(CommonUtility.formatTime(time));
	}

}
