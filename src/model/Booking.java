package model;

// This class represents a booking done by a passenger
public class Booking {
    private String bookingId; // unique ID for each booking
    private String flightNumber; // which flight is booked
    private String passengerName; // name of the person who booked

    // constructor to set all the booking details
    public Booking(String bookingId, String flightNumber, String passengerName) {
        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
    }

    // getter methods to access private variables
    public String getBookingId() {
        return bookingId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    // used to convert booking data to CSV format (for saving in file)
    public String toCSV() {
        return bookingId + "," + flightNumber + "," + passengerName;
    }

    // used when we want to print the booking object
    @Override
    public String toString() {
        return "Booking ID: " + bookingId + " | Flight No: " + flightNumber + " | Passenger: " + passengerName;
    }
}
