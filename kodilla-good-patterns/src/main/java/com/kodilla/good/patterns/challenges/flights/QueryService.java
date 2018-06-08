package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public interface QueryService {
    List<Flight> query(QueryRequest queryRequest);
}
