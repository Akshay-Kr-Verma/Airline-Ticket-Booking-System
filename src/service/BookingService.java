package service;

import model.Booking;
import repository.BookingRepository;
import repository.FlightRepository;

import java.util.List;
import java.util.UUID;

public class BookingService {
    private BookingRepository bookingRepo;
    private FlightRepository flightRepo;

    public BookingService() {
        this.bookingRepo = new BookingRepository();
        this.flightRepo = new FlightRepository();
    }

    public boolean bookFlight(String flightNumber, String passengerName) {
        if (!flightRepo.flightExists(flightNumber)) {
            return false;
        }

        String bookingId = UUID.randomUUID().toString().substring(0, 8);
        Booking booking = new Booking(bookingId, flightNumber, passengerName);
        bookingRepo.saveBooking(booking);
        return true;
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.getAllBookings();
    }
}
