package service;

import model.Flight;
import repository.FlightRepository;

import java.util.List;

public class FlightService {
    private FlightRepository repository = new FlightRepository();

    // Method to add a new flight to the system
    public void addFlight(String flightNumber, String origin, String destination, double price) {
        // Check if flight number already exists to avoid duplicates
        if (repository.flightExists(flightNumber)) {
            System.out.println("Flight number already exists!");
            return;
        }

        // Create a new Flight object with given details
        Flight flight = new Flight(flightNumber, origin, destination, price);

        // Save the flight using repository
        repository.saveFlight(flight);

        System.out.println("Flight added successfully.");
    }

    // Method to display all available flights
    public void viewFlights() {
        List<Flight> flights = repository.getAllFlights();

        // Check if any flights are available
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
            return;
        }

        // Print header message
        System.out.println("\nAvailable Flights:");

        // Print each flight's details using Flight's toString method
        flights.forEach(System.out::println);
    }
}
