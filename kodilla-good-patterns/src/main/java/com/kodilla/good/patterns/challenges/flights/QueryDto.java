package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class QueryDto {
    private Airport fromAirport;
    private List<Flight> listOfFlights;
    private boolean isFlights;

    public QueryDto(Airport fromAirport, List<Flight> listOfFlights, boolean isFlights) {
        this.fromAirport = fromAirport;
        this.listOfFlights = listOfFlights;
        this.isFlights = isFlights;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public List<Flight> getListOfFlights() {
        return listOfFlights;
    }

    public boolean isFlights() {
        return isFlights;
    }
}
