public class MinimumInRotatedSortedArray {
    public static int brute(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
        }

        return min;
    }

    public static int better(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if left part is sorted
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);

                // eliminate left half
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);

                high = mid - 1;
            }
        }

        return ans;
    }

    public static int optimal(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            // search space is already sorted
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            // if left part is sorted
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);

                // eliminate left half
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);

                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };

        // int ans = brute(arr);
        // int ans = better(arr);
        int ans = optimal(arr);

        System.out.println(ans);
    }
}