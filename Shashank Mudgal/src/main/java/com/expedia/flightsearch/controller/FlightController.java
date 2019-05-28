package com.expedia.flightsearch.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expedia.flightsearch.model.Flight;
import com.expedia.flightsearch.service.FlightService;

/**
 * @author armaan
 * The Class FlightController.
 */
@RestController
@RequestMapping(value = "/flight", produces = "application/json")
public class FlightController {


	@Autowired
	@Qualifier("flightService")
	private FlightService flightService;

	public FlightController() {
	}

	/**
	 * Queries all flights from Time between 5 hours prior and 5 hours late on today's input time.
	 *
	 * @param time the time
	 * @return the collection
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Flight> flights(@RequestParam(value = "time", required = true) String time) {
		return flightService.flightsByTime(time);

	}

}
