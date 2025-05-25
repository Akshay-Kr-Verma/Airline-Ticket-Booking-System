This is a console-based Airline Management System developed in Java using Object-Oriented Programming and Layered Architecture. It allows users to add flights, view available flights, book flights, and view all bookings. The data is stored in text files using basic file I/O operations.

To run the program double-click the run.bat file, a menu will be displayed. Adviced to start from option 2 that is, "View Flights" for better experience.

The project is structured into separate folders for better organization:
app: Contains the main application entry point (Main.java).
model: Contains model classes like Flight.java and Booking.java.
repository: Contains repository classes that handle reading from and writing to data files.
service: Contains service classes that implement the business logic.
util: Contains helper classes like InputValidator.java.
data: Contains storage files such as flights.txt and bookings.txt.

Features of the system include:
Adding new flights with details like flight number, origin, destination, and price.
Viewing all flights stored in the system.
Booking flights by entering a valid flight number and passenger name.
Viewing all confirmed bookings.
Basic validation of inputs such as flight number format, city names, and price values.
File-based data persistence without using a database.

Technologies used:
Java 23
Console-based I/O
File handling using java.io
Object-Oriented Programming (OOP) principles
Layered architecture with separation of concerns

This project was created as a group assignment for academic purposes. Some future enhancements may be made depending on feedback and project evaluation.
Thank You
