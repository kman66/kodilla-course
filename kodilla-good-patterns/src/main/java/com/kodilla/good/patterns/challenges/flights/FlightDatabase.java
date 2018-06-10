package com.kodilla.good.patterns.challenges.flights;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FlightDatabase {
    private static Set<Flight> setOfFlights = new HashSet<>();

    public static void addFlight(Flight ...flights) {
        setOfFlights.addAll(Arrays.asList(flights));
    }

    public static Set<Flight> getSetOfFlights() {
        return setOfFlights;
    }
}
