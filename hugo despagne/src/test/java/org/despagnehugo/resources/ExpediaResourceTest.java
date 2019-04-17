package org.despagnehugo.resources;

import org.despagnehugo.api.DropWizardExpediaException;
import org.despagnehugo.api.Flight;
import org.despagnehugo.data.FlightDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExpediaResourceTest
{
    @Mock
    private FlightDAO flightDAO = Mockito.mock(FlightDAO.class);

    @InjectMocks
    private ExpediaResource expediaResource = new ExpediaResource(flightDAO);

    @Test
    public void searchFlights_InvalidDepartureTimeThrowsException() throws DropWizardExpediaException
    {
        // Arrange
        when(flightDAO.getAllFlights()).thenThrow(new DropWizardExpediaException(500, "server error"));

        // Act
        // Assert
        assertThrows(DropWizardExpediaException.class, () -> expediaResource.searchFlights(Optional.of("22:30")));
    }

    @Test
    public void searchFlights_NoDepartureTime() throws DropWizardExpediaException
    {
        // Arrange
        Flight testFlight = new Flight("Test Flight", LocalTime.now());
        when(flightDAO.getAllFlights()).thenReturn(Collections.singletonList(testFlight));

        // Act
        List<Flight> flights = expediaResource.searchFlights(Optional.empty());

        // Assert
        verify(flightDAO).getAllFlights();
        assertThat(flights.size()).isEqualTo(1);
        assertThat(flights.get(0).getName()).isEqualTo("Test Flight");
    }
}