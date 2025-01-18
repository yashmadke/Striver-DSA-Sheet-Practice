public class TimeArrayRotated {
    public static int brute(int[] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
                index = i;
            }
        }

        return index;
    }

    public static int optimal(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // search space is already sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            // if left part is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }

                // eliminate left half
                low = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                high = mid - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };

        int ans = brute(arr);

        System.out.println(ans);
    }
}