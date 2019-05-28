package com.expedia.flightsearch.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.flightsearch.model.Flight;
import com.expedia.flightsearch.repository.FlightRepository;
import com.expedia.flightsearch.service.FlightService;

/**
 * The Class FlightServiceImpl.
 */
@Service("flightService")
public class FlightServiceImpl implements FlightService {

	/** The flight repo. */
	@Autowired
	private FlightRepository flightRepo;

	@Override
	public Collection<Flight> flightsByTime(String time) {
		return flightRepo.flightByTime(time);
	}


}
