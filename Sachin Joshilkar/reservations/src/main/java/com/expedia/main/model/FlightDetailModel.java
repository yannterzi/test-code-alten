package com.expedia.main.model;


/**
 * @author Sachin
 *
 */
public class FlightDetailModel {

	private String flight;

	public String getFlight() {
		return flight;
	}

	public FlightDetailModel() {

	}

	public FlightDetailModel(String flight, String departure) {

		this.flight = flight;
		this.departure = departure;
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

	private String departure;

}
