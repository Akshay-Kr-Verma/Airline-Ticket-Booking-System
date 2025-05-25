package util;

public class InputValidator {

    public static boolean isValidFlightNumber(String number) {
        return number != null && number.matches("[A-Z]{2}\\d{3,}");
    }

    public static boolean isValidCity(String city) {
        return city != null && city.matches("[A-Za-z ]{2,}");
    }

    public static boolean isValidPrice(String input) {
        try {
            double price = Double.parseDouble(input);
            return price > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
