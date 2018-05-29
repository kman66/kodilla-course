package com.kodilla.exception.test;

import java.util.*;

public class FlightFinder {
    private Map<String, Boolean> mapOfFlights = new HashMap<>();

    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        try{
            return mapOfFlights.get(flight.getArrivalAirport());
        }catch (NullPointerException npe){
            throw new RouteNotFoundException("There is any possible flight for this route");
        }
    }

    public void addFlights(Flight ... flights){
        Random random = new Random();
        boolean flightPossible = random.nextInt((1 - 0) + 1) + 0 == 1 ? true : false;

        Arrays.asList(flights).stream()
                .forEach(flight -> mapOfFlights.put(flight.getArrivalAirport(), random.nextInt(2) == 1 ? true : false));
    }

    public Map<String, Boolean> getMapOfFlights(){
        return mapOfFlights;
    }
}
