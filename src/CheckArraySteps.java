import java.util.Scanner;

/**
 * Handles user interaction via the console, managing array creation,
 * input validation, and application flow.
 */
public class CheckArraySteps {


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

        final int choice = ArrayUtils.readIntValue(scanner);
        final MenuOption menuOption = getMenuOption(choice);

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

        final int[] array = ArrayUtils.createAnArray(scanner);
        final ArrayUtils.SortOrder sorted = ArrayUtils.getSortType(array);

        System.out.println("Array is sorted: " + sorted);
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
