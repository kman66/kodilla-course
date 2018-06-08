package com.kodilla.good.patterns.challenges.flights;

import org.junit.Assert;
import org.junit.Test;

public class QueryServiceFlightsToImplTestSuite {
    @Test
    public void testQuery() {
        //Given
        //to Warszawa
        QueryServicesHelper.generateListOfAirports();
        QueryServicesHelper.generateListOfFlights();
        QueryRequest testQueryRequest = QueryServicesHelper.generateQueryRequest(3, 1);
        FlightQueryService flightQueryService = new FlightQueryService(new QueryServiceFlightsToImpl());

        //When
        QueryDto testQueryDto = flightQueryService.processQuery(testQueryRequest);

        //Then
        Assert.assertNotNull(testQueryDto);
        Assert.assertEquals(3, testQueryDto.getListOfFlights().size());
        Assert.assertTrue(FlightDatabase.getSetOfFlights().contains(testQueryDto.getListOfFlights().get(0)));
        Assert.assertTrue(FlightDatabase.getSetOfFlights().contains(testQueryDto.getListOfFlights().get(1)));
        Assert.assertTrue(FlightDatabase.getSetOfFlights().contains(testQueryDto.getListOfFlights().get(2)));
    }
}
