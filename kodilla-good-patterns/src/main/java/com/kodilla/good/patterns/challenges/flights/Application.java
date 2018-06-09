package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        Airport gdansk = new Airport("1", "Gdansk");
        Airport warszawa = new Airport("2", "Warszawa");
        Airport krakow = new Airport("3", "Krakow");
        Airport poznan = new Airport("4", "Poznan");
        Airport wroclaw = new Airport("5", "Wroclaw");
        Airport rzeszow = new Airport("6", "Rzeszow");
        Airport radom = new Airport("7", "Radom");
        Airport lodz = new Airport("8", "Lodz");

        Flight gdanskWarszawa = new Flight(gdansk, warszawa);
        Flight krakowWarszawa = new Flight(krakow, warszawa);
        Flight wroclawRzeszow = new Flight(wroclaw, rzeszow);
        Flight warszawaGdansk = new Flight(warszawa, gdansk);
        Flight krakowRadom = new Flight(krakow, radom);
        Flight radomKrakow = new Flight(radom, krakow);
        Flight warszawaLodz = new Flight(warszawa, lodz);
        Flight poznanWarszawa = new Flight(poznan, warszawa);
        Flight radomGdansk = new Flight(radom, gdansk);

        FlightDatabase.addFlight(gdanskWarszawa, krakowWarszawa, wroclawRzeszow,
                warszawaGdansk, krakowRadom, radomKrakow, warszawaLodz, poznanWarszawa, radomGdansk);

        QueryRequest queryRequest = new QueryRequest(krakow, gdansk, 0);
        FlightQueryService flightQueryService = new FlightQueryService();
        QueryDto queryDto = flightQueryService.processQuery(queryRequest);

        queryDto.getListOfFlights().stream()
                .forEach(System.out::println);
    }
}
