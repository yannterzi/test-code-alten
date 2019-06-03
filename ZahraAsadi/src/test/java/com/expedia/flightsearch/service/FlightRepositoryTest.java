package com.expedia.flightsearch.service;

import com.expedia.flightsearch.Service.FlightRepository;
import com.expedia.flightsearch.model.internal.Flight;
import com.expedia.flightsearch.model.internal.Flights;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FlightRepositoryTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private Flights flights;

    @Spy
    @InjectMocks
    private final FlightRepository flightRepository = new FlightRepository(objectMapper, flights);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFlightDetailsTest() throws Exception {
        Flights flights = new Flights();
        flights.setFlights(createFlights());
        Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(Class.class))).thenReturn(flights);
        flightRepository.getFlightDetails();

        Mockito.verify(flightRepository, Mockito.times(1)).getFlightDetails();
      }

    private List<Flight> createFlights() {

        List<Flight> flights = new ArrayList();
        Flight flight1 = new Flight();
        flight1.setFlightName("f1");
        flight1.setDeparture("7:30AM");

        Flight flight2 = new Flight();
        flight2.setFlightName("f2");
        flight2.setDeparture("3:30PM");
        flights.add(flight1);
        flights.add(flight2);

        return flights;
    }
    }


