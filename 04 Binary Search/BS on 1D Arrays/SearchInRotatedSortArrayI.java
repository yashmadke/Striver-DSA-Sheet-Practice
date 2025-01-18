import java.util.ArrayList;
import java.util.Arrays;

public class SearchInRotatedSortArrayI {
    public static int brute(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == k) {
                return i;
            }
        }

        return -1;
    }

    public static int optimal(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) == k) {
                return mid;
            }

            // if left part is sorted
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= k && k <= arr.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr.get(mid) <= k && k <= arr.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int n = 9, k = 1;

        // int ans = brute(arr, n, k);
        int ans = optimal(arr, n, k);

        if (ans == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + ans);
        }
    }
}