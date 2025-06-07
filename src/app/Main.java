package app;

import model.Booking;
import service.BookingService;
import service.FlightService;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    // Single Scanner instance for user input throughout the program
    private static final Scanner scanner = new Scanner(System.in);
    // Services to handle flight and booking operations
    private static final FlightService flightService = new FlightService();
    private static final BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        // Infinite loop to continuously show menu until user chooses to exit
        while (true) {
            showMenu(); // Display menu options to user
            String choice = scanner.nextLine().trim(); // Read and trim user input choice

            switch (choice) {
                case "1" -> addFlight(); // Option to add flight
                case "2" -> flightService.viewFlights(); // View all flights
                case "3" -> bookFlight(); // Book a flight
                case "4" -> viewBookings(); // View all bookings
                case "5" -> cancelBooking(); // Cancel a booking
                case "6" -> { // Exit option
                    System.out.println("Exiting... Thank you!");
                    scanner.close(); // Close scanner resource before exit
                    return; // End the program
                }
                default -> System.out.println("Invalid choice. Please try again."); // Handle invalid menu input
            }
        }
    }

    // Method to display the main menu options to the user
    private static void showMenu() {
        System.out.println("\nAirline Management System");
        System.out.println("1. Add Flight");
        System.out.println("2. View Flights");
        System.out.println("3. Book a Flight");
        System.out.println("4. View Bookings");
        System.out.println("5. Cancel Booking");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new flight by taking validated inputs from user
    private static void addFlight() {
        String number;
        // Loop until user enters valid flight number
        while (true) {
            System.out.print("Enter Flight Number (e.g. AI101): ");
            number = scanner.nextLine().trim();
            if (InputValidator.isValidFlightNumber(number))
                break;
            System.out.println("Invalid flight number format. Please try again.");
        }

        String origin;
        // Loop until user enters valid origin city name
        while (true) {
            System.out.print("Enter Origin City: ");
            origin = scanner.nextLine().trim();
            if (InputValidator.isValidCity(origin))
                break;
            System.out.println("Invalid origin city. Please try again.");
        }

        String dest;
        // Loop until user enters valid destination city name
        while (true) {
            System.out.print("Enter Destination City: ");
            dest = scanner.nextLine().trim();
            if (InputValidator.isValidCity(dest))
                break;
            System.out.println("Invalid destination city. Please try again.");
        }

        double price;
        // Loop until user enters valid positive price
        while (true) {
            System.out.print("Enter Price: ");
            String priceInput = scanner.nextLine().trim();
            if (InputValidator.isValidPrice(priceInput)) {
                price = Double.parseDouble(priceInput);
                break;
            }
            System.out.println("Invalid price. Please enter a positive number.");
        }

        // Add flight using FlightService after all inputs are validated
        flightService.addFlight(number, origin, dest, price);
        System.out.println("Flight added successfully.");
    }

    // Method to book a flight by taking flight number and passenger name
    private static void bookFlight() {
        System.out.print("Enter Flight Number: ");
        String flightNo = scanner.nextLine().trim();

        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine().trim();

        // Try booking the flight; show success or failure message accordingly
        if (bookingService.bookFlight(flightNo, name)) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("Invalid flight number. Booking failed.");
        }
    }

    // Method to display all existing bookings
    private static void viewBookings() {
        List<Booking> bookings = bookingService.getAllBookings();

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("All Bookings:");
            for (Booking b : bookings) {
                System.out.println(b); // Print each booking using its overridden toString()
            }
        }
    }

    // Method to cancel an existing booking by Booking ID
    private static void cancelBooking() {
        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = scanner.nextLine().trim();

        // Attempt to cancel booking; inform user of success or failure
        boolean cancelled = bookingService.cancelBooking(bookingId);
        if (cancelled) {
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Booking ID not found. Cancellation failed.");
        }
    }
}
