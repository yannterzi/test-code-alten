package com.expedia.main.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.expedia.main.services.GetFlights;
import com.expedia.main.model.FlightDetailModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author Sachin
 *
 */
@RestController
public class FlightDepartureController {

	private static final Logger logger = LogManager.getLogger(FlightDepartureController.class);
	@Autowired
	private GetFlights service;

	// Get Available next 5 hours departures
	@RequestMapping("/flight")
	public ArrayList<FlightDetailModel> greeting(@RequestParam(value = "departure") String departure)
			throws JsonParseException, JsonMappingException, IOException, ParseException {
		logger.info("Controller Started");
		return service.getAvailableFlights(departure);
	}
}