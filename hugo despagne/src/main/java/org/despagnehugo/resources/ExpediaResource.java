package org.despagnehugo.resources;

import com.codahale.metrics.annotation.Timed;
import org.despagnehugo.api.DropWizardExpediaException;
import org.despagnehugo.api.Flight;
import org.despagnehugo.data.FlightDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/flights")
@Produces(MediaType.APPLICATION_JSON)
public class ExpediaResource {
    private static final Logger    LOGGER = LoggerFactory.getLogger(ExpediaResource.class);
    private              FlightDAO flightDAO;

    public ExpediaResource(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    /**
     * Without parameters return the list of every flights available, if a departureSearchDate is specified return the list of flight available
     *  in the interval : "departureSearchDate - 5 hours TO departureSearchDate + 5 hours"
     * @param departureSearchDate date with format "h:mma", example : "10:30AM" "5:20PM"
     * @return List of Flight
     * @throws DropWizardExpediaException
     */
    @GET
    @Timed
    public List<Flight> searchFlights(@QueryParam("departureSearchDate") Optional<String> departureSearchDate) throws DropWizardExpediaException
    {
        List<Flight> flights = new ArrayList<>();
        try {
            if (!departureSearchDate.isPresent()) {
                LOGGER.info("searchFlights without date");
                flights.addAll(flightDAO.getAllFlights());
            } else {
                LOGGER.info("searchFlights with date : {}", departureSearchDate.get());
                LocalTime localTimeDeparture = LocalTime.parse(departureSearchDate.get(), FlightDAO.TIME_AMPM_FORMATTER);
                flights.addAll(flightDAO.getFlightsAvailable(localTimeDeparture, 5));
            }
        } catch (DropWizardExpediaException dropWizardExpediaException) {
            throw dropWizardExpediaException;
        } catch (Exception exception) {
            throw new DropWizardExpediaException(500, "Server Error during searchFlight", exception);
        }

        return flights;
    }
}
