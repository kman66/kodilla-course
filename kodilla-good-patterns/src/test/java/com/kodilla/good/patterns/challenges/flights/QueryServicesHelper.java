package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;

public class QueryServicesHelper {
    private static List<Airport> listOfAirports = new ArrayList<>();
    private static List<Flight> listOfFlights = new ArrayList<>();

    protected static List<Airport> generateListOfAirports() {
        Airport gdansk = new Airport("1", "Gdansk");
        Airport warszawa = new Airport("2", "Warszawa");
        Airport krakow = new Airport("3", "Krakow");
        Airport poznan = new Airport("4", "Poznan");
        Airport wroclaw = new Airport("5", "Wroclaw");

        listOfAirports.add(gdansk);
        listOfAirports.add(warszawa);
        listOfAirports.add(krakow);
        listOfAirports.add(poznan);
        listOfAirports.add(wroclaw);

        return listOfAirports;
    }

    protected static List<Flight> generateListOfFlights() {
        Flight gdanskWarszawa = new Flight(listOfAirports.get(0), listOfAirports.get(1));
        Flight krakowWarszawa = new Flight(listOfAirports.get(2), listOfAirports.get(1));
        Flight warszawaGdansk = new Flight(listOfAirports.get(1), listOfAirports.get(0));
        Flight poznanWarszawa = new Flight(listOfAirports.get(3), listOfAirports.get(1));
        Flight poznanGdansk = new Flight(listOfAirports.get(3), listOfAirports.get(0));
        Flight krakowWroclaw = new Flight(listOfAirports.get(2), listOfAirports.get(4));
        Flight wroclawGdansk = new Flight(listOfAirports.get(4), listOfAirports.get(0));

        FlightDatabase.addFlight(gdanskWarszawa, krakowWarszawa,
                warszawaGdansk, poznanWarszawa, poznanGdansk,
                krakowWroclaw, wroclawGdansk);
        listOfFlights.addAll(FlightDatabase.getSetOfFlights());

        return listOfFlights;
    }

    protected static QueryRequest generateQueryRequest(int from, int to) {
        return new QueryRequest(listOfAirports.get(from) ,listOfAirports.get(to));
    }
}
