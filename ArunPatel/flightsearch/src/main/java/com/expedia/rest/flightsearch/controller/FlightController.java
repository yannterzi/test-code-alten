package com.expedia.rest.flightsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expedia.rest.flightsearch.domain.Flight;
import com.expedia.rest.flightsearch.service.FlightService;
import com.expedia.rest.flightsearch.vo.ResponseVO;

/**
 * The Flight Controller is Rest controller which handles all rest request for
 * flight.
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */
@RestController
@RequestMapping("/flights")
@Validated
public class FlightController extends BaseController {

	@Autowired
	FlightService flightService;

	/**
	 * fetchFlight method is used to search flight based on the time provided in the
	 * request.
	 * 
	 * @param time This is only parameter required to fetch the fligt
	 *             information.Format must be hh:mmAM or hh:mmPM
	 * @return It will return the response with the flight data if falls in the
	 *         search criteria. It add plus or minus five of the request time and
	 *         return the result.
	 */
	@GetMapping(produces = "application/vnd.expedia.api.v1+json")
	public ResponseVO<List<Flight>> fetchFlight(@RequestParam(value = "time", required = true) String time) {
		return prepareSuccessResponse(flightService.fetchFlights(time));
	}
}
