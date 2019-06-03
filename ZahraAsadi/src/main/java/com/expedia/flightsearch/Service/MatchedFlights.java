package com.expedia.flightsearch.Service;

import com.expedia.flightsearch.model.internal.Flights;
import com.expedia.flightsearch.model.internal.Flight;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.Duration;

@Service
public class MatchedFlights {

    private FlightRepository flightRepository;
    private Flights matchedFlights;

    public MatchedFlights(FlightRepository flightRepository,
                          Flights flights){
        this.flightRepository=flightRepository;
        this.matchedFlights= flights;
    }

    public Flights findMatchedFlight(String timeOfDeparture) throws JsonParseException, JsonMappingException, IOException {

        Flights flights = flightRepository.getFlightDetails();
        LocalTime departureTime = timeConverter(timeOfDeparture);


        for (Flight flight: flights.getFlights()){

           Duration duration = Duration.between(timeConverter(flight.getDeparture()), departureTime);
           if(java.lang.Math.abs(duration.getSeconds()) <= 18000) {
              matchedFlights.getFlights().add(flight);
           }

        }
        return matchedFlights;
    }

    private LocalTime timeConverter(String timeOfDeparture) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("h:mma", Locale.ENGLISH);
        return LocalTime.parse(timeOfDeparture, inputFormatter);
    }
}
