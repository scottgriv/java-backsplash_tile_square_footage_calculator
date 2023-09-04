import java.util.InputMismatchException;
import java.util.Scanner;

public class BacksplashCalculator {
    public void calculateCasesNeeded() {
        // Code to calculate the number of cases needed based on user input
        Scanner scanner = new Scanner(System.in);

        // Instructions
        System.out.println("\n.:`:. Welcome to the Backsplash Calculator! .:`:.\n\n" +
                "Let's begin! \n");

        double widthFeet = 0;
        double widthInches = 0;
        double lengthFeet = 0;
        double lengthInches = 0;
        boolean validInput = false;
        String errorString = "Error: Invalid input! Let's start again, please enter a valid number.";

        do {
            try {
                System.out.println("Enter the width of the surface area in feet:");
                widthFeet = scanner.nextDouble();

                System.out.println("Enter the width of the surface area in inches:");
                widthInches = scanner.nextDouble();

                System.out.println("Enter the length of the surface area in feet:");
                lengthFeet = scanner.nextDouble();

                System.out.println("Enter the length of the surface area in inches:");
                lengthInches = scanner.nextDouble();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println(errorString + "\n");
                scanner.nextLine(); // Clear the input buffer to prevent an infinite loop
            }
        } while (!validInput);

        // Convert dimensions to total inches
        double totalWidthInches = (widthFeet * 12) + widthInches;
        double totalLengthInches = (lengthFeet * 12) + lengthInches;

        // Calculate total area in square inches
        double totalAreaSquareInches = totalWidthInches * totalLengthInches;

        // Convert total area to square feet
        double totalAreaSquareFeet = totalAreaSquareInches / 144;

        // Round the square feet for the output
        double roundedTotalAreaSquareFeet = Math.round(totalAreaSquareFeet * 100.0) / 100.0;

        // Output the calculated square feet of the surface area
        System.out.println("\nThe total square feet of the surface area is: " + roundedTotalAreaSquareFeet + " sq ft.\n");

        double caseWidthInches = 0;
        double caseLengthInches = 0;
        int caseQuantity = 0;
        validInput = false;

        do {
            try {
                System.out.println("Enter the width of a single backsplash tile in inches:");
                caseWidthInches = scanner.nextDouble();

                System.out.println("Enter the length of a single backsplash tile in inches:");
                caseLengthInches = scanner.nextDouble();

                System.out.println("Enter the backsplash tile case quantity:");
                caseQuantity = scanner.nextInt();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println(errorString + "\n");
                scanner.nextLine(); // Clear the input buffer to prevent an infinite loop
            }
        } while (!validInput);

        // Calculate case area in square inches
        double caseAreaSquareInches = caseWidthInches * caseLengthInches;

        // Convert case area to square feet
        double caseAreaSquareFeet = caseAreaSquareInches / 144;

        // Calculate number of cases needed and round up to the nearest integer
        int casesNeeded = (int) Math.ceil(totalAreaSquareFeet / caseAreaSquareFeet / caseQuantity);

        System.out.println("\nNumber of backsplash tile cases needed to cover your surface area:\n" + casesNeeded + " Cases\n");

        scanner.close();
    }

    public static void main(String[] args) {
        BacksplashCalculator calculator = new BacksplashCalculator();
        calculator.calculateCasesNeeded();
    }
}
