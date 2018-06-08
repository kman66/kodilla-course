package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.stream.Collectors;

public class QueryServiceConnectingFlightsImpl implements QueryService {
    @Override
    public List<Flight> query(QueryRequest queryRequest) {
        /*
        * FlightDatabase.getSetOfFlights().stream()
                .filter(f -> f.getArrival().equals(queryRequest.getToAirport())
                        || f.getDeparture().equals(queryRequest.getFromAirport()))
                .filter(f -> f.getDeparture().equals(f(next).getArrival())
                .collect(Collectors.toList());
        * */

        List<Airport> potentialConnectingAirports = new QueryServiceFlightsFromImpl().query(queryRequest).stream()
                .map(f -> f.getArrival())
                .collect(Collectors.toList());

        return FlightDatabase.getSetOfFlights().stream()
                .filter(f -> f.getArrival().equals(queryRequest.getToAirport())
                        || f.getDeparture().equals(queryRequest.getFromAirport()))
                .filter(f -> potentialConnectingAirports.contains(f.getArrival())
                        || potentialConnectingAirports.contains(f.getDeparture()))
                .collect(Collectors.toList());
    }
}