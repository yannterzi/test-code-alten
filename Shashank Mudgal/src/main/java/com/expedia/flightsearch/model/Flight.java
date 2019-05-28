package com.expedia.flightsearch.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Flight {
	
	/** The name. */
	private String name;
	
	/** The departure time. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date departureTime;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the departure time.
	 *
	 * @return the departure time
	 */
	public Date getDepartureTime() {
		return departureTime;
	}
	
	/**
	 * Sets the departure time.
	 *
	 * @param departureTime the new departure time
	 */
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	
	@Override
	public String toString() {
		return "Flight Name" + name + 
				"Departure Time"+ departureTime;
	}
}
