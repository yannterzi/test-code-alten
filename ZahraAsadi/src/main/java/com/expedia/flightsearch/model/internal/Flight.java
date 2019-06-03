package com.expedia.flightsearch.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Data
@Component
public class Flight {

    @JsonProperty("flight")
    private String flightName;
    private String departure;

}
