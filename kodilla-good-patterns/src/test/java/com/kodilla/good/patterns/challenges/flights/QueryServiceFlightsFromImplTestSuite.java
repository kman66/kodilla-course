package com.kodilla.good.patterns.challenges.flights;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class QueryServiceFlightsFromImplTestSuite {
    @Test
    public void testQuery() {
        //Given
        //from Poznan
        QueryServicesHelper.generateListOfAirports();
        QueryServicesHelper.generateListOfFlights();
        QueryRequest testQueryRequest = QueryServicesHelper.generateQueryRequest(3, 0);
        FlightQueryService flightQueryService = new FlightQueryService(new QueryServiceFlightsFromImpl());

        //When
        QueryDto testQueryDto = flightQueryService.processQuery(testQueryRequest);

        //Then
        Assert.assertNotNull(testQueryDto);
        Assert.assertEquals(2, testQueryDto.getListOfFlights().size());
        Assert.assertTrue(FlightDatabase.getSetOfFlights().contains(testQueryDto.getListOfFlights().get(0)));
        Assert.assertTrue(FlightDatabase.getSetOfFlights().contains(testQueryDto.getListOfFlights().get(1)));
    }
}
