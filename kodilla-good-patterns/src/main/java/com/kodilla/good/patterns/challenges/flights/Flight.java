package com.kodilla.good.patterns.challenges.flights;

import java.util.Objects;

public final class Flight {
    private final Airport departure;
    private final Airport arrival;

    public Flight(final Airport departure, final Airport arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departure, flight.departure) &&
                Objects.equals(arrival, flight.arrival);
    }

    @Override
    public int hashCode() {

        return Objects.hash(departure, arrival);
    }

    @Override
    public String toString() {
        return departure.toString().toUpperCase() +
                "->" + arrival.toString().toUpperCase();
    }
}
