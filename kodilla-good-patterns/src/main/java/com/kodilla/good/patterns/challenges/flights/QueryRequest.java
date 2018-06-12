package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDateTime;

public class QueryRequest {
    private Airport fromAirport;
    private Airport toAirport;
    private int typeOfQuery;

    public QueryRequest(Airport fromAirport, Airport toAirport, int typeOfQuery) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.typeOfQuery = typeOfQuery;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public int getTypeOfQuery() {
        return typeOfQuery;
    }
}
