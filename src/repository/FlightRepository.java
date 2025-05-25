package repository;

import model.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private static final String FILE_PATH = "../data/flights.txt"; // ✅ Correct casing used

    public FlightRepository() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error initializing flight data file.");
        }
    }

    public void saveFlight(Flight flight) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(flight.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving flight.");
        }
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    Flight flight = new Flight(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                    flights.add(flight);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading flights.");
        }
        return flights;
    }

    public boolean flightExists(String flightNumber) {
        return getAllFlights().stream().anyMatch(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
    }
}
