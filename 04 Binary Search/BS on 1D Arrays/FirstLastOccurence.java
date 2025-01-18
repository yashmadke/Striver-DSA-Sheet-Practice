public class FirstLastOccurence {
    public static int[] brute(int[] arr, int n, int k) {
        int first = -1, last = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                if (first == -1) {
                    first = i;
                } else {
                    last = i;
                }
            }
        }

        return new int[] { first, last };
    }

    public static int lowerBound(int[] arr, int n, int x) {
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

    public static int upperBound(int[] arr, int n, int x) {
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

    public static int[] optimal(int[] arr, int n, int k) {
        int lb = lowerBound(arr, n, k);

        if (lb == n || arr[lb] != k) {
            return new int[] { -1, -1 };
        }

        return new int[] { lb, upperBound(arr, n, k) - 1 };
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int target = 5;

        // int[] result = brute(arr, arr.length, target);
        int[] result = optimal(arr, arr.length, target);

        System.out.println(result[0] + " " + result[1]);
    }
}