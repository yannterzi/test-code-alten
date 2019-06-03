package com.expedia.flightsearch.Service;


import com.expedia.flightsearch.model.internal.Flights;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FlightRepository {

    private ObjectMapper objectMapper;

    private Flights flights;

    public FlightRepository(ObjectMapper objectMapper, Flights flights){
        this.flights = flights;
        this.objectMapper = objectMapper;
    }

    public Flights getFlightDetails() throws JsonParseException, IOException {

        File file = new File("./src/main/resources/storage/flightDetails.json");
        flights = objectMapper.readValue(file, Flights.class);

        return flights;
    }


}
