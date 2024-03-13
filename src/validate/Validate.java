/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import data.Report;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Validate class provides methods for input validation and user
 * interaction.
 *
 * @author he151168
 */
public class Validate {

    private static Scanner scan = new Scanner(System.in);

    /**
     * Prompts the user for a choice within a specified range and validates the
     * input.
     *
     * @param min The minimum valid choice.
     * @param max The maximum valid choice.
     * @return The choice of the user within the specified range.
     */
    public static int getChoice(int min, int max) {
        while (true) {
            try {
                System.out.print("Your choice: ");
                // Prompt the user for input
                int choice = Integer.parseInt(scan.nextLine()); // Read user input as an integer
                if (choice < min || choice > max) {
                    throw new NumberFormatException(); // Throw an exception if the input is out of range
                }
                // Return the valid choice
                return choice;
            } catch (NumberFormatException ex) {
                // Display an error message for invalid input
                System.out.print("Choose option must between 1 to 5\n");
            }
        }
    }

    /**
     * Prompts the user for a string and ensures it's not empty.
     *
     * @return A non-empty string.
     */
    public static String getString() {
        String result;
        while (true) {
            // Read user input and remove leading/trailing whitespace
            result = scan.nextLine().trim();
            // Check if the input is empty
            if (result.length() == 0 || result.isEmpty()) {
                // Prompt the user to enter a non-empty value
                System.out.print("Not empty. Enter again: ");
            } else {
                // Return the valid non-empty string
                return result;
            }
        }
    }

    /**
     * Prompts the user for a string and ensures it's not empty.
     *
     * @param inputMsg The message to display when prompting for input.
     * @param errorMsg The error message to display when the input is empty.
     * @return A non-empty string.
     */
    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            // Display the input message to the user
            System.out.print(inputMsg);
            id = scan.nextLine();
            // Check if the input is empty
            if (id.length() == 0 || id.isEmpty()) {
                // Display the error message for empty input
                System.out.println(errorMsg);
            } else {
                // Return the valid non-empty string
                return id;
            }
        }
    }

    /**
     * Checks user input for "yes" or "no".
     *
     * @param inputMessage The message to display when prompting for input.
     * @return true if the user input is "yes," false if the user input is "no."
     */
    public static boolean checkInputYesNo(String inputMessage) {
        // Display the input message to the user
        System.out.print(inputMessage);
        while (true) {
            String result = scan.nextLine();

            if (result.equalsIgnoreCase("Y")) {
                // Return true for 'Y' input
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                // Return false for 'N' input
                return false;
            }

            // Display a prompt for correct input
            System.out.println("Please input y/Y or n/N.");

            // Ask the user to enter input again
            System.out.print("Enter again: ");
        }
    }

    /**
     * Checks user input for "update" or "delete."
     *
     * @param inputMessage The message to display when prompting for input.
     * @return true if the user input is "update," false if the user input is
     * "delete."
     */
    public static boolean checkInputUpdateDelete(String inputMessage) {
        // Display the input message to the user
        System.out.print(inputMessage);
        while (true) {
            String result = scan.nextLine();
            if (result.equalsIgnoreCase("U")) {
                // Return true for 'U' input (update)
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                // Return false for 'D' input (delete)
                return false;
            }

            // Display a prompt for correct input
            System.out.println("Please input u/U or d/D.");

            // Ask the user to enter input again
            System.out.print("Enter again: ");
        }
    }

    /**
     * Checks user input for a valid course: "java," ".net," or "c/c++."
     *
     * @param inputMessage The message to display when prompting for input.
     * @return The course chosen by the user.
     */
    public static String checkInputCourse(String inputMessage) {
        // Display the input message to the user
        System.out.print(inputMessage);
        while (true) {
            String result = scan.nextLine();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")) {
                // Return the valid course name
                return result;
            }

            // Display an error message
            System.out.println("There are only three courses: Java, .Net, C/C++");

            // Ask the user to enter input again
            System.out.print("Enter again: ");
        }
    }
}
