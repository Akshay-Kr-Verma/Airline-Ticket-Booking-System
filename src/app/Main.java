package app;

import model.Flight;
import model.Booking;
import service.FlightService;
import service.BookingService;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightService flightService = new FlightService();
        BookingService bookingService = new BookingService();

        while (true) {
            //showing menu to the user
            System.out.println("\n Airline Management System");
            System.out.println("1. Add Flight");
            System.out.println("2. View Flights");
            System.out.println("3. Book a Flight");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine(); //taking user choice

            switch (choice) {
                case "1" -> {
                    //asking user to input flight details
                    System.out.print("Enter Flight Number (e.g. AI101): ");
                    String number = scanner.nextLine();
                    if (!InputValidator.isValidFlightNumber(number)) {
                        System.out.println(" Invalid flight number format.");
                        break;
                    }

                    System.out.print("Enter Origin City: ");
                    String origin = scanner.nextLine();
                    if (!InputValidator.isValidCity(origin)) {
                        System.out.println(" Invalid origin city.");
                        break;
                    }

                    System.out.print("Enter Destination City: ");
                    String dest = scanner.nextLine();
                    if (!InputValidator.isValidCity(dest)) {
                        System.out.println("Invalid destination city.");
                        break;
                    }

                    System.out.print("Enter Price: ");
                    String priceInput = scanner.nextLine();
                    if (!InputValidator.isValidPrice(priceInput)) {
                        System.out.println(" Invalid price.");
                        break;
                    }

                    //converting price to double and adding details
                    double price = Double.parseDouble(priceInput);
                    flightService.addFlight(number, origin, dest, price); //call to add flight
                }

                case "2" -> {
                    //show all flights
                    flightService.viewFlights(); 
                }

                case "3" -> {
                    //user books a flight
                    System.out.print("Enter Flight Number: ");
                    String flightNo = scanner.nextLine();

                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();

                    //if booking succesful, show user success message
                    if (bookingService.bookFlight(flightNo, name)) {
                        System.out.println(" Booking successful!");
                    } else {
                        System.out.println(" Invalid flight number. Booking failed.");
                    }
                }

                case "4" -> {
                    //show all bookings 
                    List<Booking> bookings = bookingService.getAllBookings();
                    if (bookings.isEmpty()) {
                        System.out.println(" No bookings found.");
                    } else {
                        System.out.println(" All Bookings:");
                        for (Booking b : bookings) {
                            System.out.println(b); //print all bookings
                        }
                    }
                }

                case "5" -> {
                    //exit the program
                    System.out.println(" Exiting... Thank you!");
                    scanner.close();
                    return;
                }
                //if wrong input
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
