public class LowerBound {
    public static int brute(int[] arr, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }

        return n;
    }

    public static int optimal(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 15, 19 };
        int n = 5, x = 9;

        // int index = brute(arr, n, x);
        int index = optimal(arr, n, x);

        System.out.println(index);
    }
}