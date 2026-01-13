/**
 * Purpose:
 * - This program identifies and displays perfect numbers.
 *   A perfect number is a positive integer whose sum of all positive divisors
 *   excluding itself equals the number (e.g., 6 = 1 + 2 + 3).
 *
 * Requirements (Assignment Specs):
 * 1) Part 1 (Fixed range):
 *    - Print all perfect numbers between 1 and 200.
 *
 * 2) Part 2 (User-selected range):
 *    - Prompt the user to enter an upper limit (integer) or type 'q' to quit.
 *    - For each valid upper limit entered, print all perfect numbers between 1
 *      and that limit.
 *    - Repeat until the user chooses to quit.
 *
 * 3) Output format:
 *    - Display clear headings for Part 1 and Part 2.
 *    - Print each perfect number in the format: "<number> is perfect."
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("=== Perfect Numbers (Nested Loops) ===");

        // Part 1: Determine perfect numbers between 1 and 200
        System.out.println("\nPart 1: Perfect numbers between 1 and 200:");
        findPerfectNumbersUpTo(200);

        // Part 2: Allow user to choose upper limit
        System.out.println("\nPart 2: Choose your own upper limit.");
        runUserMode();

        System.out.println("\nDone.");
    }

    /**
     * Runs user input mode: asks for an upper limit and prints perfect numbers up to that limit.
     * Demonstrates int overflow concept and uses long to support larger values.
     */
    private static void runUserMode() {
        try (Scanner scanner = new Scanner(System.in)){
            while (true) {
                System.out.println("\nEnter an upper limit (e.g., 200, 10000) or type 'q' to quit:");
                System.out.print("> ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("q")) {
                    break;
                }

                long limit;
                try {
                    limit = Long.parseLong(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a whole number, or 'q' to quit.");
                    continue;
                }

                if (limit < 1) {
                    System.out.println("Upper limit must be >= 1.");
                    continue;
                }

                // Demonstrate int limits / overflow concept
                if (limit > Integer.MAX_VALUE) {
                    System.out.println("Note: This number is larger than int max (" + Integer.MAX_VALUE + ").");
                    System.out.println("If we used int, it could overflow (wrap around) or fail to parse in some cases.");
                    System.out.println("We will use long instead to support larger limits.");
                }

                // Warning about runtime for large inputs (nested loops are slow)
                if (limit > 200000) {
                    System.out.println("Warning: This program uses nested loops (O(n^2)).");
                    System.out.println("Large limits may take a LONG time. Consider trying smaller values first.");
                }

                System.out.println("\nPerfect numbers between 1 and " + limit + ":");
                findPerfectNumbersUpTo(limit);
            }
        }
        // scanner.close(); // Optional: do not close System.in in some environments
    }

    /**
     * Finds and prints perfect numbers from 1 to limit (inclusive) using nested loops.
     * Outer loop: candidate number n
     * Inner loop: sum of divisors of n (excluding n)
     */
    public static void findPerfectNumbersUpTo(long limit) {
        // Perfect numbers are positive; 1 is not perfect
        for (long n = 2; n <= limit; n++) {
            long sum = 0;

            // Only need to check up to n/2 for proper divisors (excluding n)
            for (long d = 1; d <= n / 2; d++) {
                if (n % d == 0) {
                    sum += d;
                }
            }

            if (sum == n) {
                System.out.println(n + " is perfect.");
            }
        }
    }
}
