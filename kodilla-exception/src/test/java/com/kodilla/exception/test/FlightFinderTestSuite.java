package com.kodilla.exception.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class FlightFinderTestSuite {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAddFlights(){
        //Given
        Flight wroclawFrankfurt = new Flight("Frankfurt", "Wroclaw");
        Flight wroclawLondon = new Flight("London", "Wroclaw");
        Flight wroclawRome = new Flight("Rome", "Wroclaw");
        FlightFinder flightFinder = new FlightFinder();

        //When
        flightFinder.addFlights(wroclawFrankfurt, wroclawLondon, wroclawRome);

        //Then
        assertEquals(3, flightFinder.getMapOfFlights().size());
        assertTrue(flightFinder.getMapOfFlights().containsKey(wroclawFrankfurt.getArrivalAirport()));
        assertTrue(flightFinder.getMapOfFlights().containsKey(wroclawLondon.getArrivalAirport()));
        assertTrue(flightFinder.getMapOfFlights().containsKey(wroclawRome.getArrivalAirport()));
        //flightFinder.getMapOfFlights().forEach((f, p) -> System.out.println("Flight: " + f + " : Possible: " + p));
    }

    @Test
    public void testFindFlightException() throws Exception{
        //Given
        thrown.expect(RouteNotFoundException.class);
        thrown.expectMessage("There is any possible flight for this route");

        Flight wroclawParis = new Flight("Paris", "Wroclaw");
        Flight wroclawLisbon = new Flight("Lisbon", "Wroclaw");
        Flight wroclawMadrid = new Flight("Madrid", "Wroclaw");

        FlightFinder flightFinder = new FlightFinder();
        flightFinder.addFlights(wroclawParis, wroclawLisbon);

        //When
        flightFinder.findFlight(wroclawMadrid);

        //Then
        fail("This method should throw the RouteNotFoundException");
    }
}
