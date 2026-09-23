package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportsMap = new HashMap<>();
        airportsMap.put("Chopin Airport Warsaw", true);
        airportsMap.put("Heathrow Airport London", true);
        airportsMap.put("JFK Airport New York", false);
        airportsMap.put("Tegel Airport Berlin", false);

        String arrivalAirport = flight.getArrivalAirport();

        if (airportsMap.containsKey(arrivalAirport)) {
            Boolean isFlightPossible = airportsMap.get(arrivalAirport);
            if (isFlightPossible) {
                System.out.println("Flight to " + arrivalAirport + " is available.");
            } else {
                System.out.println("Flight to " + arrivalAirport + " is currently unavailable.");
            }
        } else {
            throw new RouteNotFoundException("Airport " + arrivalAirport + " does not exist in the database.");
        }
    }
}
