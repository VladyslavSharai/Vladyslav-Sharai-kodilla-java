package com.kodilla.exception.test;

public class FlightApplication {

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();

        Flight validFlight = new Flight("Chopin Airport Warsaw", "Heathrow Airport London");
        Flight unavailableFlight = new Flight("Chopin Airport Warsaw", "JFK Airport New York");
        Flight nonExistentFlight = new Flight("Chopin Airport Warsaw", "Unknown Airport Tokyo");

        try {
            flightFinder.findFlight(validFlight);
        } catch (RouteNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            flightFinder.findFlight(unavailableFlight);
        } catch (RouteNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            flightFinder.findFlight(nonExistentFlight);
        } catch (RouteNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("\nSearch execution completed.");
        }
    }
}