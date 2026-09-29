
/**
 * Utility class providing helper methods for array operations.
 */
public class ArrayUtils {
    /**
     * Checks if the specified array of integers is sorted in ascending order.
     *
     * @param array the array of integers to be checked
     * @return {@code true} if the array is sorted in ascending order;
     *         {@code false} otherwise
     */
    public static boolean checkArrayIsSortAsc(final int[] array){
        for (int i = 0; i < array.length -1; i++) {
            if (array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }
}
