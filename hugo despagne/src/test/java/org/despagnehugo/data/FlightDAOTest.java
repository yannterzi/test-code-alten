package org.despagnehugo.data;

import org.despagnehugo.api.DropWizardExpediaException;
import org.despagnehugo.api.Flight;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FlightDAOTest
{
    private static FlightDAO flightDAO = new FlightDAO();

    @Test
    public void getAllFlights() throws DropWizardExpediaException
    {
        // Arrange
        // Act
        List<Flight> allFlights = flightDAO.getAllFlights();

        // Assert
        assertThat(allFlights.size()).isEqualTo(4);
        assertThat(allFlights.get(1).getName()).isEqualTo("United Airline 6115");
        assertThat(allFlights.get(2).getDepartureTime().getHour()).isEqualTo(12);
        assertThat(allFlights.get(2).getDepartureTime().getMinute()).isEqualTo(30);
        assertThat(allFlights.get(3).getDepartureTime().getHour()).isEqualTo(15);
        assertThat(allFlights.get(3).getDepartureTime().getMinute()).isEqualTo(0);
    }

    @Test
    public void getFlightsAvailable_OneFlight() throws DropWizardExpediaException
    {
        // Arrange
        // Act
        List<Flight> oneFlight = flightDAO.getFlightsAvailable(LocalTime.parse("12:00PM", FlightDAO.TIME_AMPM_FORMATTER), 1);

        // Assert
        assertThat(oneFlight.size()).isEqualTo(1);
        assertThat(oneFlight.get(0).getName()).isEqualTo("WestJet 6456");
        assertThat(oneFlight.get(0).getDepartureTime().getHour()).isEqualTo(12);
        assertThat(oneFlight.get(0).getDepartureTime().getMinute()).isEqualTo(30);
    }

    @Test
    public void getFlightsAvailable_TwoFlight() throws DropWizardExpediaException
    {
        // Arrange
        // Act
        List<Flight> oneFlight = flightDAO.getFlightsAvailable(LocalTime.parse("6:00AM", FlightDAO.TIME_AMPM_FORMATTER), 5);

        // Assert
        assertThat(oneFlight.size()).isEqualTo(2);
        assertThat(oneFlight.get(0).getName()).isEqualTo("Air Canada 8099");
        assertThat(oneFlight.get(0).getDepartureTime().getHour()).isEqualTo(7);
        assertThat(oneFlight.get(0).getDepartureTime().getMinute()).isEqualTo(30);
        assertThat(oneFlight.get(1).getName()).isEqualTo("United Airline 6115");
        assertThat(oneFlight.get(1).getDepartureTime().getHour()).isEqualTo(10);
        assertThat(oneFlight.get(1).getDepartureTime().getMinute()).isEqualTo(30);
    }
}