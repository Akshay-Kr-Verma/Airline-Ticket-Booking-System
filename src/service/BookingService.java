package service;

import model.Booking;
import repository.BookingRepository;
import repository.FlightRepository;

import java.util.List;
import java.util.UUID;

public class BookingService {
    private BookingRepository bookingRepo; // to save and get bookings
    private FlightRepository flightRepo; // to check flights exist

    // constructor to create repository objects
    public BookingService() {
        this.bookingRepo = new BookingRepository();
        this.flightRepo = new FlightRepository();
    }

    // book flight if flight number exists
    public boolean bookFlight(String flightNumber, String passengerName) {
        // check if flight exists or not
        if (!flightRepo.flightExists(flightNumber)) {
            return false; // flight not found so booking failed
        }

        // generate random booking id (8 chars)
        String bookingId = UUID.randomUUID().toString().substring(0, 8);
        // create booking object
        Booking booking = new Booking(bookingId, flightNumber, passengerName);
        // save booking to file
        bookingRepo.saveBooking(booking);
        return true; // booking successful
    }

    // get all bookings from repository
    public List<Booking> getAllBookings() {
        return bookingRepo.getAllBookings();
    }
}
