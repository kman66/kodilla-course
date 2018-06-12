package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.OrderDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlightQueryServiceTestSuite {
    private static List<Airport> airportList;
    private static List<Flight> flightList;

    @BeforeClass
    public static void generateAirportAndFlightList() {
        airportList = new ArrayList<>();
        flightList = new ArrayList<>();

        //AIRPORTS
        Airport gdansk = new Airport("1", "Gdansk");
        Airport warszawa = new Airport("2", "Warszawa");
        Airport krakow = new Airport("3", "Krakow");
        Airport poznan = new Airport("4", "Poznan");
        Airport wroclaw = new Airport("5", "Wroclaw");
        Airport rzeszow = new Airport("6", "Rzeszow");
        Airport radom = new Airport("7", "Radom");
        Airport lodz = new Airport("8", "Lodz");

        airportList.add(gdansk);     // 0
        airportList.add(warszawa);   // 1
        airportList.add(krakow);     // 2
        airportList.add(poznan);     // 3
        airportList.add(wroclaw);    // 4
        airportList.add(rzeszow);    // 5
        airportList.add(radom);      // 6
        airportList.add(lodz);       // 7

        //FLIGHTS
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

        flightList.add(gdanskWarszawa);     // 0
        flightList.add(krakowWarszawa);     // 1
        flightList.add(wroclawRzeszow);     // 2
        flightList.add(warszawaGdansk);     // 3
        flightList.add(krakowRadom);        // 4
        flightList.add(radomKrakow);        // 5
        flightList.add(warszawaLodz);       // 6
        flightList.add(poznanWarszawa);     // 7
        flightList.add(radomGdansk);        // 8
    }

    @Test
    public void testQueryFromAirportSuccessCase() {
        //Given
        FlightQueryService flightQueryService = new FlightQueryService();
        QueryRequest queryRequestFromAirport = new QueryRequest(airportList.get(2), null, 1);

        //When
        QueryDto fromQueryDto = flightQueryService.processQuery(queryRequestFromAirport);

        //Then
        Assert.assertNotNull(fromQueryDto);
        Assert.assertEquals(true, fromQueryDto.isFlights());
        Assert.assertEquals(2, fromQueryDto.getListOfFlights().size());
        Assert.assertTrue(fromQueryDto.getListOfFlights().contains(flightList.get(1)));
        Assert.assertTrue(fromQueryDto.getListOfFlights().contains(flightList.get(4)));
    }

    @Test
    public void testQueryFromAirportFailureCase() {
        //Given
        FlightQueryService flightQueryService = new FlightQueryService();
        QueryRequest queryRequestFromAirport = new QueryRequest(airportList.get(7), null, 1);

        //When
        QueryDto fromQueryDto = flightQueryService.processQuery(queryRequestFromAirport);

        //Then
        Assert.assertNotNull(fromQueryDto);
        Assert.assertEquals(false, fromQueryDto.isFlights());
        Assert.assertTrue(fromQueryDto.getListOfFlights().isEmpty());
    }

    @Test
    public void testQueryToAirportSuccessTest() {
        //Given
        FlightQueryService flightQueryService = new FlightQueryService();
        QueryRequest queryRequestToAirport = new QueryRequest(null, airportList.get(1), 2);

        //When
        QueryDto toQueryDto = flightQueryService.processQuery(queryRequestToAirport);

        //Then
        Assert.assertNotNull(toQueryDto);
        Assert.assertEquals(true, toQueryDto.isFlights());
        Assert.assertEquals(3, toQueryDto.getListOfFlights().size());
        Assert.assertTrue(toQueryDto.getListOfFlights().contains(flightList.get(0)));
        Assert.assertTrue(toQueryDto.getListOfFlights().contains(flightList.get(1)));
        Assert.assertTrue(toQueryDto.getListOfFlights().contains(flightList.get(7)));
    }

    @Test
    public void testQueryToAirportFailureCase() {
        //Given
        FlightQueryService flightQueryService = new FlightQueryService();
        QueryRequest queryRequestToAirport = new QueryRequest(null, airportList.get(3), 2);

        //When
        QueryDto toQueryDto = flightQueryService.processQuery(queryRequestToAirport);

        //Then
        Assert.assertNotNull(toQueryDto);
        Assert.assertEquals(false, toQueryDto.isFlights());
        Assert.assertTrue(toQueryDto.getListOfFlights().isEmpty());
    }

    @Test
    public void testQueryConnectingFlightsSuccessCase() {
        //Given
        FlightQueryService flightQueryService = new FlightQueryService();
        QueryRequest queryRequestConnectingFlights = new QueryRequest(airportList.get(2), airportList.get(0), 3);

        //When
        QueryDto connectingQueryDto = flightQueryService.processQuery(queryRequestConnectingFlights);

        //Then
        Assert.assertNotNull(connectingQueryDto);
        Assert.assertEquals(true, connectingQueryDto.isFlights());
        Assert.assertEquals(4, connectingQueryDto.getListOfFlights().size());
        Assert.assertTrue(connectingQueryDto.getListOfFlights().contains(flightList.get(1)));
        Assert.assertTrue(connectingQueryDto.getListOfFlights().contains(flightList.get(3)));
        Assert.assertTrue(connectingQueryDto.getListOfFlights().contains(flightList.get(4)));
        Assert.assertTrue(connectingQueryDto.getListOfFlights().contains(flightList.get(8)));
    }

    @Test
    public void testQueryConnectingFlightsFailureCase() {
        //Given
        FlightQueryService flightQueryService = new FlightQueryService();
        QueryRequest queryRequestConnectingFlights = new QueryRequest(airportList.get(3), airportList.get(2), 3);

        //When
        QueryDto connectingQueryDto = flightQueryService.processQuery(queryRequestConnectingFlights);

        //Then
        Assert.assertNotNull(connectingQueryDto);
        Assert.assertEquals(false, connectingQueryDto.isFlights());
        Assert.assertTrue(connectingQueryDto.getListOfFlights().isEmpty());
    }
}
