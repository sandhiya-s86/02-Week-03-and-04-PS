import java.util.*;

public class PS6 {

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    static int floorValue(int[] arr, int target) {
        int floor = -1;

        for (int value : arr) {
            if (value <= target)
                floor = value;
        }

        return floor;
    }

    static int ceilingValue(int[] arr, int target) {
        for (int value : arr) {
            if (value >= target)
                return value;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] unsorted = {50, 10, 100, 25};
        int[] sorted = {10, 25, 50, 100};

        int target = 30;

        int index = linearSearch(unsorted, target);

        if (index == -1)
            System.out.println("Linear Search: Not Found");
        else
            System.out.println("Found at index " + index);

        System.out.println("Insertion Point: " + insertionPoint(sorted, target));
        System.out.println("Floor Value: " + floorValue(sorted, target));
        System.out.println("Ceiling Value: " + ceilingValue(sorted, target));
    }
}