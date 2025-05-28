package repository;

import model.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    // path for flights data file
    private static final String FILE_PATH = "../data/flights.txt";

    // constructor checks if the file exists, if not creates it
    public FlightRepository() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error initializing flight data file.");
        }
    }

    // save flight details to file (append mode)
    public void saveFlight(Flight flight) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(flight.toCSV()); // save in CSV format
            writer.newLine(); // next flight on new line
        } catch (IOException e) {
            System.out.println("Error saving flight.");
        }
    }

    // read all flights from file and return as a list
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // split line by comma to get flight details
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    // create flight object and add to list
                    Flight flight = new Flight(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                    flights.add(flight);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading flights.");
        }
        return flights;
    }

    // check if flight with given number already exists
    public boolean flightExists(String flightNumber) {
        return getAllFlights().stream().anyMatch(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
    }
}
