package util;

public class InputValidator {

    // Validate Flight Number:
    // Must be exactly 2 uppercase letters followed by 3 or more digits, no spaces
    // allowed
    public static boolean isValidFlightNumber(String number) {
        if (number == null)
            return false;
        number = number.trim(); // remove spaces around the input
        // Regex: Start with 2 uppercase letters [A-Z]{2}, followed by at least 3 digits
        // \d{3,}, match whole string (^...$)
        return number.matches("^[A-Z]{2}\\d{3,}$");
    }

    // Validate City Name:
    // Letters and single spaces allowed between words, min length 2, no
    // leading/trailing spaces, no multiple consecutive spaces
    public static boolean isValidCity(String city) {
        if (city == null)
            return false;
        city = city.trim(); // remove leading/trailing spaces
        // Regex explanation:
        // Starts with letters [A-Za-z]+
        // Then zero or more groups of one space and letters ( [A-Za-z]+)*
        // Ensures no multiple consecutive spaces and only letters + spaces
        return city.matches("^[A-Za-z]+( [A-Za-z]+)*$") && city.length() >= 2;
    }

    // Validate Price:
    // Must be a positive number greater than 0, no upper limit set here
    public static boolean isValidPrice(String input) {
        if (input == null)
            return false;
        input = input.trim(); // remove spaces around the input
        try {
            double price = Double.parseDouble(input);
            return price > 0;
        } catch (NumberFormatException e) {
            // if input is not a valid number, return false
            return false;
        }
    }
}
