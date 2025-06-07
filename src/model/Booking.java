package model;

// This class represents a booking done by a passenger
public class Booking {
    private String bookingId; // unique ID for each booking
    private String flightNumber; // flight number associated with this booking
    private String passengerName; // name of the passenger who made the booking

    /**
     * Constructor to initialize a booking object with all details.
     * 
     * @param bookingId     Unique identifier for the booking
     * @param flightNumber  Flight number for which booking is made
     * @param passengerName Name of the passenger
     */
    public Booking(String bookingId, String flightNumber, String passengerName) {
        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
    }

    // Getter method for booking ID
    public String getBookingId() {
        return bookingId;
    }

    // Getter method for flight number
    public String getFlightNumber() {
        return flightNumber;
    }

    // Getter method for passenger name
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * Converts the booking details into a CSV formatted string.
     * Useful for saving booking data into text file.
     * 
     * @return CSV format string of booking details
     */
    public String toCSV() {
        return bookingId + "," + flightNumber + "," + passengerName;
    }

    /*
     * Returns a formatted string representation of booking details.
     * This is useful when printing the booking object.
     */
    @Override
    public String toString() {
        return "Booking ID: " + bookingId + " | Flight No: " + flightNumber + " | Passenger: " + passengerName;
    }
}
