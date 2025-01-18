import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementInSortedArray {
    public static int brute(ArrayList<Integer> arr) {
        int n = arr.size();

        if (n == 1) {
            return arr.get(0);
        }

        for (int i = 0; i < n; i++) {
            // check for first index
            if (i == 0) {
                if (!arr.get(i).equals(arr.get(i + 1))) {
                    return arr.get(i);
                }
            }
            // check for last index
            else if (i == n - 1) {
                if (!arr.get(i).equals(arr.get(i - 1))) {
                    return arr.get(i);
                }
            } else {
                if (!arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(arr.get(i + 1))) {
                    return arr.get(i);
                }
            }
        }

        return -1;
    }

    public static int better(ArrayList<Integer> arr) {
        int n = arr.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans ^ arr.get(i);
        }

        return ans;
    }

    public static int optimal(ArrayList<Integer> arr) {
        int n = arr.size();

        // edge cases
        if (n == 1) {
            return arr.get(0);
        }
        if (!arr.get(0).equals(arr.get(1))) {
            return arr.get(0);
        }
        if (!arr.get(n - 1).equals(arr.get(n - 2))) {
            return arr.get(n - 1);
        }

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if arr[mid] is the single element
            if (!arr.get(mid).equals(arr.get(mid + 1)) && !arr.get(mid).equals(arr.get(mid - 1))) {
                return arr.get(mid);
            }

            // we are in the left
            if ((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))
                    || (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))) {
                low = mid + 1;
            }
            // we are in the right
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));

        // int ans = brute(arr);
        // int ans = better(arr);
        int ans = optimal(arr);

        System.out.println(ans);
    }
}