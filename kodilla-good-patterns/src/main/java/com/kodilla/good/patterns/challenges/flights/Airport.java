package com.kodilla.good.patterns.challenges.flights;

import java.util.Objects;

public final class Airport {
    private final String airportId;
    private final String name;

    public Airport(final String airportId, final String name) {
        this.airportId = airportId;
        this.name = name;
    }

    public String getAirportId() {
        return airportId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airportId, airport.airportId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(airportId);
    }

    @Override
    public String toString() {
        return name;
    }
}
