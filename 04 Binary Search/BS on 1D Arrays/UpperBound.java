public class UpperBound {
    public static int brute(int[] arr, int x, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                return i;
            }
        }

        return n;
    }

    public static int optimal(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                // look for smaller index on left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 9, 15, 19 };
        int n = 6, x = 9;

        // int index = brute(arr, x, n);
        int index = optimal(arr, x, n);

        System.out.println(index);
    }
}