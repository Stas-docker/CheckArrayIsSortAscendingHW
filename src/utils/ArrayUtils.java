package utils;


import enums.SortOrder;

import java.util.Scanner;

/**
 * Utility class providing helper methods for array operations.
 */
public class ArrayUtils {

    /**
     * Determines the sorting order of the array.
     *
     * @param array array to check
     * @return ASCENDING, DESCENDING, or UNSORTED
     */
    public static SortOrder getSortType(final int[] array) {
        SortOrder sortOrder = SortOrder.UNSORTED;

        if (array.length >= 2) {
            if (isAscending(array)) {
                sortOrder = SortOrder.ASCENDING;
            } else if (isDescending(array)) {
                sortOrder = SortOrder.DESCENDING;
            }
        }

        return sortOrder;
    }

    /**
     * Checks if the array is strictly ascending.
     */
    public static boolean isAscending(int[] array) {
        boolean isAscending = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                isAscending = false;
            }
        }

        return isAscending;
    }

    /**
     * Checks if the array is strictly descending.
     */
    public static boolean isDescending(int[] array) {
        boolean isDescending = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                isDescending = false;
            }
        }

        return isDescending;
    }

    /**
     * Creates and populates an integer array based on user input.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the populated array of integers
     */
    public static int[] createAnArray(final Scanner scanner) {

        final int arrayLength = readLengthArray(scanner);
        final int[] array = new int[arrayLength];

        System.out.println("\nType the elements of your Array using ENTER: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = readIntValue(scanner);
        }

        return array;

    }

    /**
     * Prompts the user to enter the size for the array.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the specified number of elements for the array
     */
    private static int readLengthArray(final Scanner scanner) {

        int numberOfElements = -1;

        while (numberOfElements < 0) {

            System.out.print("\nChoose how many elements should be in your Array: ");
            numberOfElements = readIntValue(scanner);

            if (numberOfElements < 0) {
                System.out.println("\nThe number of elements in an array cannot be less than 0, try again:");
            }
        }

        return numberOfElements;

    }

    /**
     * Reads the next integer value entered by the user.
     *
     * @param scanner the scanner used for reading input
     * @return the integer entered by the user
     */
    public static int readIntValue(final Scanner scanner) {

        validateIntegerInput(scanner);
        final int number = scanner.nextInt();
        scanner.nextLine();

        return number;

    }

    /**
     * Validates if a user's prompt is an integer value
     *
     * @param scanner the {@link Scanner} instance used for user input
     */
    private static void validateIntegerInput(final Scanner scanner) {

        while (!scanner.hasNextInt()) {

            if (scanner.hasNextBigInteger()) {
                System.out.println("\nNumber is too large for an integer! Try again: ");
            } else {
                System.out.println("\nInvalid input! Please enter a valid integer number: ");
            }

            scanner.nextLine();

        }

    }

}
