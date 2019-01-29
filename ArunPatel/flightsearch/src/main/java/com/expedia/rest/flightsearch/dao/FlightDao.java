package com.expedia.rest.flightsearch.dao;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.expedia.rest.flightsearch.domain.Flight;
import com.expedia.rest.flightsearch.util.ApplicationConstant;
import com.expedia.rest.flightsearch.util.CommonUtility;

/**
 * The FlightDao is the Repository which handles the database operation for
 * Flight. Currently It does not contain any code related to database.
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */

@Repository
public class FlightDao {

	List<Flight> flights;

	/**
	 * Initialize the list with default dummy data.
	 */
	public FlightDao() {
		flights = new ArrayList<Flight>();
		flights.add(new Flight("Air Canada 8099", "7:30AM"));
		flights.add(new Flight("United Airline 6115", "10:30AM"));
		flights.add(new Flight("WestJet 6456", "12:30PM"));
		flights.add(new Flight("Delta 3833", "3:00PM"));
	}

	/**
	 * fetchFlight method is used to search flight based on the time provided in the
	 * argument.
	 * 
	 * @param time This is only parameter required to fetch the flight information.
	 * @return It will return the List of flight if falls in the search criteria. It
	 *         add plus or minus five of the request time and return the result.
	 */
	public List<Flight> fetchFlights(String starttime) {
		LocalTime localTimeStart = LocalTime.parse(CommonUtility.convert24Time(starttime))
				.minus(ApplicationConstant.HOUR_THRESOLD, ChronoUnit.HOURS);
		LocalTime localTimeEnd = LocalTime.parse(CommonUtility.convert24Time(starttime))
				.plus(ApplicationConstant.HOUR_THRESOLD, ChronoUnit.HOURS);
		return flights.stream().filter(isWithinTimeRange(localTimeStart, localTimeEnd))
				.collect(Collectors.<Flight>toList());
	}

	/**
	 * isWithinTimeRange method is Predicate used to filter the list based on the
	 * start and end time.
	 * 
	 * @param localTimeStart It is the upper time limit
	 * @param localTimeEnd   It is the lower time limit.
	 * 
	 * @return It will return the Predicate boolean true if the condition match
	 *         other wise false.
	 */
	private Predicate<Flight> isWithinTimeRange(LocalTime localTimeStart, LocalTime localTimeEnd) {
		return p -> !LocalTime.parse(CommonUtility.convert24Time(p.getDeparture())).isBefore(localTimeStart)
				&& !LocalTime.parse(CommonUtility.convert24Time(p.getDeparture())).isAfter(localTimeEnd);
	}

}
