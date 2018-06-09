package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.OrderDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FlightQueryServiceTestSuite {
    @Test
    public void testProcessQuery() {
        //Given
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

        FlightQueryService flightQueryService = new FlightQueryService();

        QueryRequest queryRequestFromAirport = new QueryRequest(krakow, null, 1);
        QueryRequest queryRequestToAirport = new QueryRequest(null, warszawa, 2);
        QueryRequest queryRequestConnectingFlights = new QueryRequest(krakow, gdansk, 3);

        //When
        QueryDto fromQueryDto = flightQueryService.processQuery(queryRequestFromAirport);
        QueryDto toQueryDto = flightQueryService.processQuery(queryRequestToAirport);
        QueryDto connectingQueryDto = flightQueryService.processQuery(queryRequestConnectingFlights);

        //Then
        Assert.assertNotNull(fromQueryDto);
        Assert.assertEquals(true, fromQueryDto.isFlights());
        Assert.assertEquals(2, fromQueryDto.getListOfFlights().size());
        Assert.assertTrue(fromQueryDto.getListOfFlights().contains(krakowWarszawa));
        Assert.assertTrue(fromQueryDto.getListOfFlights().contains(krakowRadom));

        Assert.assertNotNull(toQueryDto);
        Assert.assertEquals(true, toQueryDto.isFlights());
        Assert.assertEquals(3, toQueryDto.getListOfFlights().size());
        Assert.assertTrue(toQueryDto.getListOfFlights().contains(gdanskWarszawa));
        Assert.assertTrue(toQueryDto.getListOfFlights().contains(krakowWarszawa));
        Assert.assertTrue(toQueryDto.getListOfFlights().contains(poznanWarszawa));

        Assert.assertNotNull(connectingQueryDto);
        Assert.assertEquals(true, connectingQueryDto.isFlights());
        Assert.assertEquals(4, connectingQueryDto.getListOfFlights().size());
        Assert.assertTrue(connectingQueryDto.getListOfFlights().contains(krakowWarszawa));
        Assert.assertTrue(connectingQueryDto.getListOfFlights().contains(warszawaGdansk));
        Assert.assertTrue(connectingQueryDto.getListOfFlights().contains(krakowRadom));
        Assert.assertTrue(connectingQueryDto.getListOfFlights().contains(radomGdansk));
    }
}
