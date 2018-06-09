package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class QueryDto {
    private List<Flight> listOfFlights;
    private boolean isFlights;

    public QueryDto(List<Flight> listOfFlights, boolean isFlights) {
        this.listOfFlights = listOfFlights;
        this.isFlights = isFlights;
    }

    public List<Flight> getListOfFlights() {
        return listOfFlights;
    }

    public boolean isFlights() {
        return isFlights;
    }
}
