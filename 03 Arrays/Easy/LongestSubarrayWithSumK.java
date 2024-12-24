import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    // better solution
    public static int getLongestSubarray(int[] a, long k) {
        int n = a.length;

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            long rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    // optimal solution
    public static int getLongestSubarray(int[] arr, int k) {
        int n = arr.length;

        int left = 0, right = 0;
        long sum = arr[0];
        int maxLen = 0;

        while (right < n) {
            // if sum > k, reduce the subaaray from left until sum becomes less or equal to
            // k
            while (left <= right && sum > k) {
                sum = sum - arr[left];
                left++;
            }

            // if sum == k, update the maxLen
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // move forward the right pointer
            right++;

            if (right < n) {
                sum += arr[right];
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 1, 9 };
        long k = 10;

        int len = getLongestSubarray(a, k);

        System.out.println("The length of the longest subarray is: " + len);
    }
}