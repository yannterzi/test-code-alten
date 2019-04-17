package org.despagnehugo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;

public class Flight
{
    private String    name;
    private LocalTime departureTime;

    public Flight() {
        // Jackson deserialization
    }

    public Flight(String name, LocalTime departureTime) {
        this.name = name;
        this.departureTime = departureTime;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public LocalTime getDepartureTime() {
        return departureTime;
    }
}
