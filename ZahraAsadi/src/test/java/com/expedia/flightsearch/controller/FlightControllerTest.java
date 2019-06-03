package com.expedia.flightsearch.controller;


import com.expedia.flightsearch.model.internal.Flight;
import com.expedia.flightsearch.model.internal.Flights;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;


public class FlightControllerTest {

    @Mock
    private FlightController flightController;

    @Mock
    private Flights storeData;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFlightsTest() throws Exception{
        Mockito.when(flightController.getFlights(any())).thenReturn(createFlights());
        flightController.getFlights(null);
        Mockito.verify(flightController, Mockito.times(1)).getFlights(null);
    }



    private Flights createFlights() {

        Flights response = new Flights();
        List<Flight> flights = new ArrayList();
        Flight flight1 = new Flight();
        flight1.setFlightName("f1");
        flight1.setDeparture("7:30AM");

        Flight flight2 = new Flight();
        flight2.setFlightName("f2");
        flight2.setDeparture("3:30PM");
        flights.add(flight1);
        flights.add(flight2);
        response.setFlights(flights);
        return response;
}

}
