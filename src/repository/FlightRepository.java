package repository;

import model.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    // Path for flights data file
    private static final String FILE_PATH = "../data/flights.txt";

    // Constructor checks if the file exists; if not, creates it
    public FlightRepository() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error initializing flight data file.");
        }
    }

    // Save flight details to file (append mode)
    public void saveFlight(Flight flight) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(flight.toCSV()); // save flight data in CSV format
            writer.newLine(); // new line for next flight entry
        } catch (IOException e) {
            System.out.println("Error saving flight.");
        }
    }

    // Read all flights from file and return as a list
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line by comma to get flight details
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    // Create Flight object and add to list
                    Flight flight = new Flight(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                    flights.add(flight);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading flights.");
        }
        return flights;
    }

    // Check if flight with given flight number already exists
    public boolean flightExists(String flightNumber) {
        return getAllFlights().stream()
                .anyMatch(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
    }
}
