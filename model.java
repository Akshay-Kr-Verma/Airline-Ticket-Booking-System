package model;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private double price;

    public Flight(String flightNumber, String source, String destination, double price) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public String toCSV() {
        return flightNumber + "," + source + "," + destination + "," + price;
    }

    public static Flight fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Flight(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }

    @Override
    public String toString() {
        return String.format("Flight %s | From: %s | To: %s | Price: ₹%.2f", flightNumber, source, destination, price);
    }
}
