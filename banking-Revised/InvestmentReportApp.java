package RevisedCode;
/*
Thomas Teagarden
Southern New Hampshire University
CS-210 / CS-499 Enhancement
Software Engineering and Design
*/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InvestmentReportApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("Investment Calculator");
            System.out.println("=".repeat(60));

            // Input
            double initialAmount = getPositiveDouble(scanner, "Initial Investment Amount: $");
            double monthlyDeposit = getPositiveDouble(scanner, "Monthly Deposit: $");
            double annualInterest = getPositiveDouble(scanner, "Annual Interest Rate (%): ");
            int numYears = (int) getPositiveDouble(scanner, "Number of Years: ");

            System.out.print("\nPress Enter to view your investment report...");
            scanner.nextLine();

            // Generate report
            boolean withMonthly = monthlyDeposit != 0;
            String reportType = withMonthly ? "WITH MONTHLY DEPOSITS" : "WITHOUT MONTHLY DEPOSITS";
            System.out.println("\n" + "-".repeat(60));
            System.out.println("REPORT " + reportType);
            System.out.println("-".repeat(60));

            try {
                String filename = generateFilename();
                displayReport(initialAmount, monthlyDeposit, annualInterest, numYears, withMonthly, filename);
                System.out.println("\nReport successfully written to '" + filename + "'.");
            } catch (IOException e) {
                System.out.println("Error writing report to CSV: " + e.getMessage());
            }

            // Ask to repeat
            System.out.println("\n" + "=".repeat(60));
            System.out.print("Would you like to perform another calculation? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (!choice.equals("yes") && !choice.equals("y")) {
                System.out.println("\nExiting program. Thank you and goodbye!");
                break;
            }
        }

        scanner.close();
    }

    // Ensures positive double input
    private static double getPositiveDouble(Scanner scanner, String prompt) {
        double value = -1;
        while (value < 0) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value < 0) {
                    System.out.println("Please enter a non-negative number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    // Report generator + CSV export
    private static void displayReport(double initialAmount, double monthlyDeposit, double annualInterest,
                                      int numYears, boolean includeMonthly, String filename) throws IOException {

        String title = "Balance and Interest Report " + (includeMonthly ? "With Monthly Deposits" : "Without Monthly Deposits");

        System.out.println("\n" + "=".repeat(70));
        System.out.printf("%s%n", centerString(title, 70));
        System.out.println("=".repeat(70));
        System.out.printf("%-10s%-30s%s%n", "Year", "Year End Balance", "Year End Interest");
        System.out.println("-".repeat(70));

        double balance = initialAmount;

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Year,Year End Balance,Year End Interest");

            for (int year = 1; year <= numYears; year++) {
                double yearlyInterest = 0;

                for (int month = 0; month < 12; month++) {
                    if (includeMonthly) {
                        balance += monthlyDeposit;
                    }
                    double monthlyInterest = balance * (annualInterest / 100 / 12);
                    balance += monthlyInterest;
                    yearlyInterest += monthlyInterest;
                }

                System.out.printf("%-10d $%,25.2f    $%,18.2f%n", year, balance, yearlyInterest);
                writer.printf("%d,%.2f,%.2f%n", year, balance, yearlyInterest);
            }
        }
    }

    // Generate a timestamped filename
    private static String generateFilename() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = LocalDateTime.now().format(formatter);
        return "investment_report_" + timestamp + ".csv";
    }

    // Helper for center alignment
    private static String centerString(String str, int width) {
        int padding = (width - str.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + str;
    }
}
