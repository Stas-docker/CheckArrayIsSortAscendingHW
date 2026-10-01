import java.util.Scanner;

/**
 * Handles user interaction via the console, managing array creation,
 * input validation, and application flow.
 */
public class CheckArraySteps {

    /**
     * Represents the available options in the main menu.
     */
    public enum MenuOption {

        /**
         * Option to proceed with array creation and sorting evaluation.
         */
        ENTER_ARRAY,

        /**
         * Option to gracefully terminate the application loop.
         */
        EXIT,

        /**
         * Fallback option for unrecognized or invalid user inputs.
         */
        UNKNOWN

    }

    /**
     * Starts the application, manages the main menu loop, and handles resource cleanup
     * by initializing the console scanner.
     */
    public static void startGame() {

        try (final Scanner scanner = new Scanner(System.in)) {
            MenuOption choice = MenuOption.UNKNOWN;

            while (choice != MenuOption.EXIT) {
                choice = readChoiceToContinue(scanner);
                handleMenuChoice(choice, scanner);

            }
        }

    }

    /**
     * Prompts the user to enter the size for the array.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the specified number of elements for the array
     */
    private static int readLengthArray(final Scanner scanner) {

        System.out.print("\nChoose how many elements should be in your Array: ");

        final int numberOfElements = validateInput(scanner);

        return numberOfElements;

    }

    /**
     * Creates and populates an integer array based on user input.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the populated array of integers
     */
    private static int[] createAnArray(final Scanner scanner) {

        final int arrayLength = readLengthArray(scanner);
        final int[] array = new int[arrayLength];

        System.out.println("\nType the elements of your Array using ENTER: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = validateInput(scanner);
        }

        return array;

    }

    /**
     * Continuously prompts the user until a valid integer is entered.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the validated integer value
     */
    private static int validateInput(final Scanner scanner) {

        while (!scanner.hasNextInt()) {
            System.out.println("\nInvalid input! Please enter a valid number: ");
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

        System.out.println("""
                Hello! This program checks if your array is sorted.
                
                1. Enter array
                2. Exit
                
                Choose an option:\s""");

    }

    /**
     * Prompts the user with the main menu and retrieves their validated choice as a {@link MenuOption}.
     *
     * @param scanner the {@link Scanner} instance used for user input
     * @return the selected {@link MenuOption}
     */
    private static MenuOption readChoiceToContinue(final Scanner scanner) {

        showMenu();

        int choice = validateInput(scanner);
        MenuOption menuOption = getMenuOption(choice);

        return menuOption;

    }

    /**
     * Maps an integer choice code to its corresponding {@link MenuOption}.
     *
     * @param choice the integer code entered by the user
     * @return the matching {@link MenuOption}
     */
    private static MenuOption getMenuOption(final int choice) {
        return switch (choice) {
            case 1 -> MenuOption.ENTER_ARRAY;
            case 2 -> MenuOption.EXIT;
            default -> MenuOption.UNKNOWN;
        };
    }

    /**
     * Coordinates the creation of an array, evaluates its sorting order,
     * and prints the result to the console.
     *
     * @param scanner the {@link Scanner} instance used for user input
     */
    private static void processArrayChecking(final Scanner scanner) {

        int[] array = createAnArray(scanner);
        ArrayUtils.SortOrder isSorted = ArrayUtils.getSortType(array);

        System.out.println("Array is sorted: " + isSorted);
        System.out.println("-------------------------------------------------------------------");

    }

    /**
     * Executes the appropriate action corresponding to the user's menu choice.
     *
     * @param choice  the selected {@link MenuOption}
     * @param scanner the {@link Scanner} instance used for user input
     */
    private static void handleMenuChoice(final MenuOption choice, final Scanner scanner) {
        switch (choice) {
            case ENTER_ARRAY -> processArrayChecking(scanner);
            case EXIT -> System.out.println("Goodbye!");
            default -> System.out.println("\nInvalid option! Please try again.\n");

        }
    }

}
