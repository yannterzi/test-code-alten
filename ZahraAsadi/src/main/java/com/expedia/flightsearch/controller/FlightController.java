package com.expedia.flightsearch.controller;

import com.expedia.flightsearch.Service.MatchedFlights;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.expedia.flightsearch.model.internal.Flights;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/flightSearch")
public class FlightController {

    private MatchedFlights matchedFlights;

    public FlightController(MatchedFlights matchedFlights) {
        this.matchedFlights = matchedFlights;
    }

    @RequestMapping(method= RequestMethod.GET)
    public Flights getFlights(@Valid @RequestParam(name = "time") String departure) throws JsonParseException, IOException {

        return matchedFlights.findMatchedFlight(departure);
    }
}
