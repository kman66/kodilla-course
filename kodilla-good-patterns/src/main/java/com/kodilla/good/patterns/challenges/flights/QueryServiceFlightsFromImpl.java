package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.stream.Collectors;

public class QueryServiceFlightsFromImpl implements QueryService {
    @Override
    public List<Flight> query(QueryRequest queryRequest) {
        return FlightDatabase.getSetOfFlights().stream()
                .filter(f -> f.getDeparture().equals(queryRequest.getFromAirport()))
                .collect(Collectors.toList());
    }
}
