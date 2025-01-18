public class SearchInRotatedSortArrayII {
    public static boolean brute(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return true;
            }
        }

        return false;
    }

    public static boolean optimal(int[] arr, int k) {
        int n = arr.length;

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                return true;
            }

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // if left part is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
        int k = 3;

        // boolean ans = brute(arr, k);
        boolean ans = optimal(arr, k);

        if (ans == false) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found");
        }
    }
}