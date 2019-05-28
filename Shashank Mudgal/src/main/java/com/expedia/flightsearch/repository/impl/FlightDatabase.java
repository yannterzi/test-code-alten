package com.expedia.flightsearch.repository.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.expedia.flightsearch.model.Flight;

/**
 * The Class FlightDatabase.
 */
public class FlightDatabase {

	/** The flights. */
	private static Map<String,Flight> flights = new HashMap<>();
	
	/** The calendar. */
	private static Calendar calendar = Calendar.getInstance();

	static {

		Calendar cal = Calendar.getInstance();
		calendar.set(cal.get(Calendar.YEAR), 
		cal.get(Calendar.MONTH), 
		cal.get(Calendar.DATE),7, 30, 00);

		Flight flight1 = new  Flight();
		flight1.setName("Air Canada 8099");
		flight1.setDepartureTime(calendar.getTime());
		flights.put(flight1.getName(), flight1);

		calendar.set(cal.get(Calendar.YEAR), 
				cal.get(Calendar.MONTH), 
				cal.get(Calendar.DATE),10, 30, 00);

		Flight flight2 = new  Flight();
		flight2.setName("United Airline 6115");
		flight2.setDepartureTime(calendar.getTime());
		flights.put(flight2.getName(), flight2);
		
		calendar.set(cal.get(Calendar.YEAR), 
				cal.get(Calendar.MONTH), 
				cal.get(Calendar.DATE),12, 30, 00);

		Flight flight3 = new  Flight();
		flight3.setName("WestJet 6456");
		flight3.setDepartureTime(calendar.getTime());
		flights.put(flight3.getName(), flight3);
		
		calendar.set(cal.get(Calendar.YEAR), 
				cal.get(Calendar.MONTH), 
				cal.get(Calendar.DATE),15, 00, 00);

		Flight flight4 = new  Flight();
		flight4.setName("Delta 3833");
		flight4.setDepartureTime(calendar.getTime());
		flights.put(flight4.getName(), flight4);
		
		calendar.set(cal.get(Calendar.YEAR), 
				cal.get(Calendar.MONTH), 
				cal.get(Calendar.DATE),1, 00, 00);

	}
	
	/**
	 * Gets the flights.
	 *
	 * @return the flights
	 */
	public static Map<String,Flight> getFlights() {
		return flights;
	}

}
