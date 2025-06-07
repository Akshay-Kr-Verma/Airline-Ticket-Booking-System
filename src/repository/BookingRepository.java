package repository;

import model.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    private static final String FILE_PATH = "../data/bookings.txt";

    public BookingRepository() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists())
                file.createNewFile(); // create file if not exists
        } catch (IOException e) {
            System.out.println("Error initializing booking data file.");
        }
    }

    // Save new booking (append to file)
    public void saveBooking(Booking booking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(booking.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving booking.");
        }
    }

    // Read all bookings from file and return as list
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 3) {
                    Booking booking = new Booking(tokens[0], tokens[1], tokens[2]);
                    bookings.add(booking);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading bookings.");
        }
        return bookings;
    }

    // NEW METHOD: Delete booking by ID
    public boolean deleteBookingById(String bookingId) {
        List<Booking> bookings = getAllBookings(); // read all bookings
        boolean removed = bookings.removeIf(b -> b.getBookingId().equalsIgnoreCase(bookingId));

        if (removed) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Booking b : bookings) {
                    writer.write(b.toCSV()); // write remaining bookings
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error updating bookings after deletion.");
                return false; // indicate deletion failed due to IO error
            }
        }

        return removed; // return true if deleted, false if not found
    }
}
