package com.expedia.rest.flightsearch.domain;

/**
 * The Flight is the Entity class which represents the table of the database.
 * Currently there is no database so its plan JAVA class.
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */
public class Flight {

	private String flight;
	private String departure;

	public Flight() {
		super();
	}

	public Flight(String flight, String departure) {
		super();
		this.flight = flight;
		this.departure = departure;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

}
