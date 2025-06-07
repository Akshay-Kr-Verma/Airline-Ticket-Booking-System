package model;

/**
 * Represents a Flight with flight details.
 */
public class Flight {
    private String flightNumber; // Unique identifier for the flight
    private String origin; // Origin city of the flight
    private String destination; // Destination city of the flight
    private double price; // Price of the flight ticket

    /**
     * Constructor to initialize the flight details.
     *
     * @param flightNumber Unique flight number
     * @param origin       Origin city name
     * @param destination  Destination city name
     * @param price        Price of the ticket
     */
    public Flight(String flightNumber, String origin, String destination, double price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    // Getter for flight number
    public String getFlightNumber() {
        return flightNumber;
    }

    // Getter for origin city
    public String getOrigin() {
        return origin;
    }

    // Getter for destination city
    public String getDestination() {
        return destination;
    }

    // Getter for flight price
    public double getPrice() {
        return price;
    }

    /**
     * Converts the flight details to CSV format for file storage.
     *
     * @return CSV formatted string of flight details
     */
    public String toCSV() {
        return flightNumber + "," + origin + "," + destination + "," + price;
    }

    /**
     * Returns a human-readable string representation of the flight.
     *
     * @return formatted flight details string
     */
    @Override
    public String toString() {
        return "Flight No: " + flightNumber + " | From: " + origin + " | To: " + destination + " | Price: Rs " + price;
    }
}
