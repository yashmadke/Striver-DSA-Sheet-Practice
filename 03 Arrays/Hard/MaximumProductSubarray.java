public class MaximumProductSubarray {
    public static int brute(int[] arr) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int prod = 1;

                for (int k = i; k <= j; k++) {
                    prod *= arr[k];
                }

                result = Math.max(result, prod);
            }
        }

        return result;
    }

    public static int better(int[] arr) {
        int result = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            int p = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                result = Math.max(result, p);
                p *= arr[j];
            }

            result = Math.max(result, p);
        }

        return result;
    }

    public static int optimal(int[] arr) {
        int n = arr.length;

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pre == 0) {
                pre = 1;
            }

            if (suff == 0) {
                suff = 1;
            }

            pre *= arr[i];
            suff *= arr[n - i - 1];

            ans = Math.max(ans, Math.max(pre, suff));
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, -3, 0, -4, -5 };

        // int ans = brute(nums);
        // int ans = better(nums);
        int ans = optimal(nums);

        System.out.println(ans);
    }
}