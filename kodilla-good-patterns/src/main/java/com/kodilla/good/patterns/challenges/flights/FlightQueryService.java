package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class FlightQueryService {
    private QueryService queryService;

    public FlightQueryService(QueryService queryService) {
        this.queryService = queryService;
    }

    public QueryDto processQuery(QueryRequest queryRequest) {
        List<Flight> resultList = queryService.query(queryRequest);

        if (resultList.isEmpty()) {
            return new QueryDto(queryRequest.getFromAirport(), resultList, false);
        }

        return new QueryDto(queryRequest.getFromAirport(), resultList, true);
    }
}
