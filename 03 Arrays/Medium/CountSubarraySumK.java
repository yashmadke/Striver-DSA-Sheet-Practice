public class CountSubarraySumK {
    public static int bruteForce(int[] arr, int key) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) { // starting index i
            for (int j = i; j < n; j++) { // ending index j
                // calculate sum from i to j
                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                if (sum == key) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int better(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        // starting index i
        for (int i = 0; i < n; i++) {
            int sum = 0;

            // ending index j
            for (int j = i; j < n; j++) {
                // calculate sum from i to j
                sum += arr[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        int k = 6;

        // int count = bruteForce(arr, k);
        int count = better(arr, k);

        System.out.println(count);
    }
}