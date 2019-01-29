package com.expedia.example.demo.model;


import com.expedia.example.demo.util.TimeUtils;

public class Flight {

	private String flight;
	private String departure;

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}
	
	public Flight withFlight(String flight) {
		this.flight = flight;
		return this;
	}

	public String getDeparture() {
		return departure;
	}
	
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	public Flight withDeparture(String departure) {
		this.departure = departure;
		return this;
	}

	public int minutesFromStartOfTheDay() {
		
		return TimeUtils.getMinutesFromStartOfDay(departure);

	}

}
