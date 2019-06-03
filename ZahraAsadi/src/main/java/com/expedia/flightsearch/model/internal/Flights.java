package com.expedia.flightsearch.model.internal;

import com.expedia.flightsearch.model.internal.Flight;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Flights implements Serializable {
    private List<Flight> flights = new ArrayList();
}
