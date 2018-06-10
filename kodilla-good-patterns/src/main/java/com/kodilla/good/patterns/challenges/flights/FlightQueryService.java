package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightQueryService {

    public QueryDto processQuery(QueryRequest queryRequest) {
        List<Flight> resultList = query(queryRequest);

        if (resultList.isEmpty()) {
            return new QueryDto(resultList, false);
        }

        return new QueryDto(resultList, true);
    }

    private List<Flight> query(QueryRequest queryRequest) {
        if (queryRequest.getTypeOfQuery() == 1) {
            return queryFromAirport(queryRequest.getFromAirport());
        } else if (queryRequest.getTypeOfQuery() == 2) {
            return queryToAirport(queryRequest.getToAirport());
        }

        return queryConnectingFlights(queryRequest);
    }

    private List<Flight> queryFromAirport(Airport fromAirport) {
        return FlightDatabase.getSetOfFlights().stream()
                .filter(f -> f.getDeparture().equals(fromAirport))
                .collect(Collectors.toList());
    }

    private List<Flight> queryToAirport(Airport toAirport) {
        return FlightDatabase.getSetOfFlights().stream()
                .filter(f -> f.getArrival().equals(toAirport))
                .collect(Collectors.toList());
    }

    private List<Flight> queryConnectingFlights(QueryRequest queryRequest) {
        List<Airport> potentialConnectingAirports = queryFromAirport(queryRequest.getFromAirport()).stream()
                .map(f -> f.getArrival())
                .collect(Collectors.toList());

        List<Flight> resultFlights = FlightDatabase.getSetOfFlights().stream()
                .filter(f -> f.getArrival().equals(queryRequest.getToAirport())
                        || f.getDeparture().equals(queryRequest.getFromAirport()))
                .filter(f -> potentialConnectingAirports.contains(f.getArrival())
                        || potentialConnectingAirports.contains(f.getDeparture()))
                .collect(Collectors.toList());

        boolean isFligthFrom = resultFlights.stream()
                .map(f -> f.getDeparture())
                .filter(f -> f.equals(queryRequest.getFromAirport()))
                .collect(Collectors.toList()).isEmpty();

        boolean isFlightTo = resultFlights.stream()
                .map(f -> f.getArrival())
                .filter(f -> f.equals(queryRequest.getToAirport()))
                .collect(Collectors.toList()).isEmpty();


        return (!isFligthFrom && !isFlightTo) ? resultFlights : new ArrayList<Flight>();
    }
}
