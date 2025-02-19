import java.util.Scanner;
public class task1 {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    public static double convertTemperature(double value, String fromUnit, String toUnit) {
        if (fromUnit.equals(toUnit)) {
            return value;
        }
        
        switch (fromUnit) {
            case "C":
                return toUnit.equals("F") ? celsiusToFahrenheit(value) : celsiusToKelvin(value);
            case "F":
                return toUnit.equals("C") ? fahrenheitToCelsius(value) : fahrenheitToKelvin(value);
            case "K":
                return toUnit.equals("C") ? kelvinToCelsius(value) : kelvinToFahrenheit(value);
            default:
                throw new IllegalArgumentException("Invalid input unit");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature value: ");
        double value = scanner.nextDouble();
        System.out.print("Enter current unit (C, F, K): ");
        String fromUnit = scanner.next().toUpperCase();
        System.out.print("Enter target unit (C, F, K): ");
        String toUnit = scanner.next().toUpperCase();
        
        try {
            double result = convertTemperature(value, fromUnit, toUnit);
            System.out.println("Converted temperature: " + result + " " + toUnit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        scanner.close();
    }
}
