import java.util.*;

public class PS5 {

    // Linear Search - First Occurrence
    static int linearFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Occurrence = Index " + i);
                System.out.println("Comparisons = " + comparisons);
                return i;
            }
        }

        System.out.println("Not Found");
        return -1;
    }

    // Linear Search - Last Occurrence
    static int linearLast(String[] arr, String target) {
        int comparisons = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Last Occurrence = Index " + i);
                System.out.println("Comparisons = " + comparisons);
                return i;
            }
        }

        System.out.println("Not Found");
        return -1;
    }

    // Binary Search Exact Match
    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Search Found at Index " + mid);
                System.out.println("Comparisons = " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not Found");
        return -1;
    }

    // Count Occurrences
    static int countOccurrences(String[] arr, String target) {
        int count = 0;

        for (String s : arr) {
            if (s.equals(target))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accA", "accB", "accB", "accC"};

        System.out.println("Sorted Logs:");
        System.out.println(Arrays.toString(logs));

        System.out.println();

        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        System.out.println();

        binarySearch(logs, "accB");

        int count = countOccurrences(logs, "accB");
        System.out.println("Total Occurrences of accB = " + count);
    }
}