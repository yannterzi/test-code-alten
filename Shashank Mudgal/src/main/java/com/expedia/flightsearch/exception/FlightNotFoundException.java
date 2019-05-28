package com.expedia.flightsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class FlightNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND) 
public class FlightNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new flight not found exception.
	 *
	 * @param message the message
	 */
	public FlightNotFoundException(String message) {
		super(message);
		
	}
	
}
