import java.util.Scanner;

/**
 * Utility class providing helper methods for array operations.
 */
public class ArrayUtils {

    /**
     * Represents the sorting order or status of an array.
     */
    public enum SortOrder {

        /**
         * Indicates that the elements are arranged in non-decreasing order.
         */
        ASCENDING,

        /**
         * Indicates that the elements are arranged in non-increasing order.
         */
        DESCENDING,

        /**
         * Indicates that the elements are not sorted in any particular order.
         */
        UNSORTED

    }

    /**
     * Determines the sorting type of the given array.
     *
     * @param array the array of integers to check
     * @return ASCENDING, DESCENDING, or UNSORTED depending on the array elements
     */
    public static SortOrder getSortType(final int[] array) {
        SortOrder sortOrder = SortOrder.ASCENDING;
        boolean hasAsc = hasAscendingPair(array);
        boolean hasDesc = hasDescendingPair(array);

        if (hasDesc) {
            sortOrder = SortOrder.DESCENDING;
        }

        if (hasAsc && hasDesc) {
            sortOrder = SortOrder.UNSORTED;
        }

        return sortOrder;

    }

    /**
     * Checks if the array has at least one ascending pair (a[i] < a[i+1]).
     *
     * @param array the array of integers to check
     * @return true if an ascending pair is found, false otherwise
     */
    private static boolean hasAscendingPair(final int[] array) {

        boolean hasPair = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                hasPair = true;
                break;
            }
        }

        return hasPair;

    }

    /**
     * Checks if the array has at least one descending pair (a[i] > a[i+1]).
     *
     * @param array the array of integers to check
     * @return true if a descending pair is found, false otherwise
     */
    private static boolean hasDescendingPair(final int[] array) {

        boolean hasPair = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                hasPair = true;
                break;
            }
        }

        return hasPair;

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

        int numberOfElements = 0;

        while (numberOfElements <= 0) {

            System.out.print("\nChoose how many elements should be in your Array: ");
            numberOfElements = readIntValue(scanner);

            if (numberOfElements <= 0) {
                System.out.println("\nThe number of elements in an array cannot be 0 or less, try again:");
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
