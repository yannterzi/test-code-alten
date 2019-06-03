package com.expedia.flightsearch.service;

import com.expedia.flightsearch.Service.FlightRepository;
import com.expedia.flightsearch.Service.MatchedFlights;
import com.expedia.flightsearch.model.internal.Flight;
import com.expedia.flightsearch.model.internal.Flights;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.Silent.class)
public class MatchedFlightTest {

    @Mock
    private FlightRepository flightRepository;

    private MatchedFlights matchedFlights;

    private Flights flights = new Flights();


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        matchedFlights = new MatchedFlights(flightRepository,
                flights);
    }


    @Test
    public void aMatchedFlightFound() throws Exception {

        Mockito.when(flightRepository.getFlightDetails()).thenReturn(createStoreData());
        Flights matchedFlight = matchedFlights.findMatchedFlight("8:30AM");
        Assert.assertEquals(matchedFlight.getFlights().get(0).getFlightName(),"f1");
    }

    @Test
    public void noMatchedFlightFound() throws Exception {

        Mockito.when(flightRepository.getFlightDetails()).thenReturn(createStoreData());
        Flights matchedFlight = matchedFlights.findMatchedFlight("9:00PM");
        Assert.assertEquals(matchedFlight.getFlights().size(),0);
    }

    private Flights createStoreData() {

        Flights storeData = new Flights();
        storeData.setFlights(createFlights());
        return storeData;
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
