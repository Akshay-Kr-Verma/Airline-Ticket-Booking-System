package model;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private double price;

    public Flight(String flightNumber, String origin, String destination, double price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public double getPrice() { return price; }

    public String toCSV() {
        return flightNumber + "," + origin + "," + destination + "," + price;
    }

    @Override
    public String toString() {
        return "Flight No: " + flightNumber + " | From: " + origin + " | To: " + destination + " | Price: ₹" + price;
    }
}
