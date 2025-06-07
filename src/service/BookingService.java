package service;

import model.Booking;
import repository.BookingRepository;
import repository.FlightRepository;

import java.util.List;
import java.util.UUID;

public class BookingService {
    private BookingRepository bookingRepo; // To save and retrieve bookings
    private FlightRepository flightRepo; // To verify if flights exist

    // Constructor initializes repository objects
    public BookingService() {
        this.bookingRepo = new BookingRepository();
        this.flightRepo = new FlightRepository();
    }

    // Method to book a flight if flight number exists
    public boolean bookFlight(String flightNumber, String passengerName) {
        // Check if flight exists in the system
        if (!flightRepo.flightExists(flightNumber)) {
            return false; // Flight not found, booking failed
        }

        // Generate random booking ID (first 8 chars of UUID)
        String bookingId = UUID.randomUUID().toString().substring(0, 8);

        // Create a new Booking object
        Booking booking = new Booking(bookingId, flightNumber, passengerName);

        // Save the booking using repository
        bookingRepo.saveBooking(booking);

        return true; // Booking successful
    }

    // Retrieve all bookings from the repository
    public List<Booking> getAllBookings() {
        return bookingRepo.getAllBookings();
    }

    // Cancel booking by booking ID, returns true if cancelled successfully
    public boolean cancelBooking(String bookingId) {
        return bookingRepo.deleteBookingById(bookingId);
    }
}
