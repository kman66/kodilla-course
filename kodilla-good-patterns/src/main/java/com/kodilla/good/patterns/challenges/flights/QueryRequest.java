package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDateTime;

public class QueryRequest {
    private Airport fromAirport;
    private Airport toAirport;

    public QueryRequest(Airport fromAirport, Airport toAirport) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }
}
