import java.util.Scanner;
/**
 * Handles user interaction via the console, managing array creation,
 * input validation, and application flow.
 */
public class CheckArraySteps {

    /**
     * Starts the application by initializing the console scanner resource
     * and launching the main menu logic.
     */
    public static void startGame() {
        try (final Scanner scanner = new Scanner(System.in);){
            chooseAnOptionInMenu(scanner);
        }
    }

    /**
     * Prompts the user to enter the size for the array.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the specified number of elements for the array
     */
    private static int chooseLengthOfAnArray(final Scanner scanner) {
        System.out.println();
        System.out.print("Choose how many elements should be in your Array: ");
        final int numberOfElements = validateInputOfInt(scanner);
        return numberOfElements;
    }

    /**
     * Creates and populates an integer array based on user input.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the populated array of integers
     */
    private static int[] createAnArray(final Scanner scanner) {
        final int[] array = new int[chooseLengthOfAnArray(scanner)];
        System.out.println();
        System.out.println("Type the elements of your Array using ENTER: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = validateInputOfInt(scanner);
        }
        return array;
    }

    /**
     * Continuously prompts the user until a valid integer is entered.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the validated integer value
     */
    private static int validateInputOfInt(final Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println();
            System.out.println("Invalid input! Please enter a valid number: ");
            scanner.nextLine();
        }
        final int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    /**
     * Prints the welcome message and available navigation menu options to the console.
     */
    private static void showMenu() {
        System.out.println("Hello! This program checks if your array is sorted in ascending order.");
        System.out.println();
        System.out.println("1. Enter array");
        System.out.println("2. Exit");
        System.out.println();
        System.out.print("Choose an option: ");
    }

/**
 * Controls the main menu loop and delegates actions based on user selection.
 *
 * @param scanner the {@link Scanner} instance used for user input
 */

private static void chooseAnOptionInMenu(final Scanner scanner) {
    int choice = 0;
    while (choice != 2){
        showMenu();
        choice = validateInputOfInt(scanner);

        if (choice == 1){
            int[] array = createAnArray(scanner);
            boolean isSorted = ArrayUtils.checkArrayIsSortAsc(array);
            System.out.println("Array is sorted: " + isSorted);
            System.out.println("-------------------------------------------------------------------");
        } else if (choice == 2) {
            System.out.println("Goodbye!");
        }
        else {
            System.out.println();
            System.out.println("Invalid option! Please try again.");
            System.out.println();
        }
    }
  }
}