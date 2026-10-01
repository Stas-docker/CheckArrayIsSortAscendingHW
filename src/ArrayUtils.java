
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
     * Determines the sorting status of the specified integer array.
     *
     * @param array the array of integers to be checked
     * @return {@link SortOrder#ASCENDING} if the elements are sorted in non-decreasing order;
     * {@link SortOrder#DESCENDING} if the elements are sorted in non-increasing order;
     * {@link SortOrder#UNSORTED} if the elements are not sorted
     */
    public static SortOrder getSortType(final int[] array) {
        SortOrder sortOrder = SortOrder.ASCENDING;
        boolean hasAsc = hasAscending(array);
        boolean hasDesc = hasDescending(array);

        if (hasDesc) {
            sortOrder = SortOrder.DESCENDING;
        }

        if (hasAsc && hasDesc) {
            sortOrder = SortOrder.UNSORTED;
        }

        return sortOrder;

    }

    /**
     * Checks if the array contains at least one ascending step (a[i] < a[i+1]).
     *
     * @param array the array of integers to be checked
     * @return {@code true} if an ascending pair is found; {@code false} otherwise
     */
    private static boolean hasAscending(final int[] array) {
        boolean hasAscending = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                hasAscending = true;
            }
        }

        return hasAscending;

    }

    /**
     * Checks if the array contains at least one descending step (a[i] > a[i+1]).
     *
     * @param array the array of integers to be checked
     * @return {@code true} if a descending pair is found; {@code false} otherwise
     */
    private static boolean hasDescending(final int[] array) {
        boolean hasDescending = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                hasDescending = true;
            }
        }

        return hasDescending;

    }

}
