import java.util.Scanner;

public class Calculator {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enhanced Console Calculator - ShadowFox Intern Submission");
        while (true) {
            printMenu();
            String choice = sc.next().trim();
            if (choice.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                break;
            }
            try {
                handleChoice(choice);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("Choose operation:");
        System.out.println("1) Basic arithmetic (+ - * /)");
        System.out.println("2) Square root");
        System.out.println("3) Power (x^y)");
        System.out.println("4) Temperature conversion (C <-> F)");
        System.out.println("5) Length conversion (meters <-> kilometers)");
        System.out.println("Q) Quit");
        System.out.print("Enter choice: ");
    }

    private static void handleChoice(String c) {
        switch (c) {
            case "1":
                basicArithmetic();
                break;
            case "2":
                squareRoot();
                break;
            case "3":
                power();
                break;
            case "4":
                tempConversion();
                break;
            case "5":
                lengthConversion();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void basicArithmetic() {
        System.out.print("Enter first number: ");
        double a = readDouble();
        System.out.print("Enter operator (+ - * /): ");
        char op = sc.next().trim().charAt(0);
        System.out.print("Enter second number: ");
        double b = readDouble();
        double res;
        switch (op) {
            case '+': res = a + b; break;
            case '-': res = a - b; break;
            case '*': res = a * b; break;
            case '/':
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                    return;
                }
                res = a / b; break;
            default:
                System.out.println("Unknown operator.");
                return;
        }
        System.out.println("Result: " + res);
    }

    private static void squareRoot() {
        System.out.print("Enter number: ");
        double x = readDouble();
        if (x < 0) {
            System.out.println("Cannot compute square root of negative number.");
            return;
        }
        System.out.println("sqrt(" + x + ") = " + Math.sqrt(x));
    }

    private static void power() {
        System.out.print("Enter base: ");
        double base = readDouble();
        System.out.print("Enter exponent: ");
        double exp = readDouble();
        System.out.println(base + " ^ " + exp + " = " + Math.pow(base, exp));
    }

    private static void tempConversion() {
        System.out.println("1) Celsius to Fahrenheit");
        System.out.println("2) Fahrenheit to Celsius");
        System.out.print("Choice: ");
        String ch = sc.next().trim();
        if (ch.equals("1")) {
            System.out.print("Enter °C: ");
            double c = readDouble();
            System.out.println(c + " °C = " + (c * 9/5 + 32) + " °F");
        } else if (ch.equals("2")) {
            System.out.print("Enter °F: ");
            double f = readDouble();
            System.out.println(f + " °F = " + ((f - 32) * 5/9) + " °C");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void lengthConversion() {
        System.out.println("1) meters to kilometers");
        System.out.println("2) kilometers to meters");
        System.out.print("Choice: ");
        String ch = sc.next().trim();
        if (ch.equals("1")) {
            System.out.print("Enter meters: ");
            double m = readDouble();
            System.out.println(m + " m = " + (m / 1000.0) + " km");
        } else if (ch.equals("2")) {
            System.out.print("Enter kilometers: ");
            double km = readDouble();
            System.out.println(km + " km = " + (km * 1000.0) + " m");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static double readDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
