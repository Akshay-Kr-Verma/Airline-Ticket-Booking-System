package service;

import model.Flight;
import repository.FlightRepository;

import java.util.List;

public class FlightService {
    private FlightRepository repository = new FlightRepository();

    public void addFlight(String flightNumber, String origin, String destination, double price) {
        if (repository.flightExists(flightNumber)) {
            System.out.println("❌ Flight number already exists!");
            return;
        }

        Flight flight = new Flight(flightNumber, origin, destination, price);
        repository.saveFlight(flight);
        System.out.println("✅ Flight added successfully.");
    }

    public void viewFlights() {
        List<Flight> flights = repository.getAllFlights();
        if (flights.isEmpty()) {
            System.out.println("⚠️ No flights found.");
            return;
        }
        System.out.println("\n🛫 Available Flights:");
        flights.forEach(System.out::println);
    }
}
