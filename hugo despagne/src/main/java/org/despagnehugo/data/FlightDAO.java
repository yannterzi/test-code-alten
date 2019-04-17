package org.despagnehugo.data;

import org.despagnehugo.api.DropWizardExpediaException;
import org.despagnehugo.api.Flight;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic DAO for the flights, in mosts cases we would retrieve the flights from a DB, in our case it hold the flight list.
 * For a more scalable solution, a factory pattern could also be used.
 * Use of JDK 8 new API LocalTime to manipulate time.
 */
public class FlightDAO
{
    private static final Logger            LOGGER              = LoggerFactory.getLogger(FlightDAO.class);
    public static final  DateTimeFormatter TIME_AMPM_FORMATTER =DateTimeFormatter.ofPattern("h:mma");


    // Basic Copy Paste of the data given in the exercise
    private static String                 flightsData         = "{\n" + "\"flights\": [\n" + "{\n" + "\"flight\": \"Air Canada 8099\",\n" + "\"departure\": \"7:30AM\"\n" + "},\n" + "{\n"
            + "\"flight\": \"United Airline 6115\",\n" + "\"departure\": \"10:30AM\"\n" + "},\n" + "{\n" + "\"flight\": \"WestJet 6456\",\n" + "\"departure\": \"12:30PM\"\n" + "},\n" + "{\n"
            + "\"flight\": \"Delta 3833\",\n" + "\"departure\": \"3:00PM\"\n" + "}\n" + "]\n" + "}";

    /**
     * Get all the flights available
     */
    public List<Flight> getAllFlights() throws DropWizardExpediaException
    {
        LOGGER.info("getAllFlights");
        JSONArray jsonFlights = new JSONObject(flightsData).getJSONArray("flights");
        List<Flight> flights = new ArrayList<>();

        for(Object objectFlight : jsonFlights) {
            JSONObject jsonFlight = (JSONObject) objectFlight;
            flights.add(getFlightFromJson(jsonFlight));
        }

        return flights;
    }

    /**
     * Flights available for a specific time, plus/minus a given number of hours, ordered by ascending departure time
     * In a DB context, a specific query would be done, instead of retrieving every flight then filtering them
     *
     * @param time time to target for the Flight returned
     * @param plusMinusHours Flight with a departure date plus/minus this numbers of hours are valid
     * @return List of Flight answering the specified conditions
     */
    public List<Flight> getFlightsAvailable(LocalTime time, int plusMinusHours) throws DropWizardExpediaException
    {
        LOGGER.info("getAllFlights for time {} and hours difference : {}", time, plusMinusHours);

        List<Flight> allFlights = getAllFlights();
        LocalTime minimalTime = time.minusHours(plusMinusHours);
        LocalTime maximalTime = time.plusHours(plusMinusHours);

        return allFlights.stream()
                .filter(flight -> flight.getDepartureTime().isAfter(minimalTime))
                .filter(flight -> flight.getDepartureTime().isBefore(maximalTime))
                .collect(Collectors.toList());
    }

    private Flight getFlightFromJson(JSONObject jsonFlight) throws DropWizardExpediaException
    {
        try {
            return  new Flight(jsonFlight.getString("flight"), LocalTime.parse(jsonFlight.getString("departure"), TIME_AMPM_FORMATTER));
        } catch (Exception exception) {
            throw new DropWizardExpediaException(500, "Exception while unserializing data", exception);
        }
    }
}
