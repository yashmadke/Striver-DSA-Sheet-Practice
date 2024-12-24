public class MaxScoreSubarray {
    public static int maxScore(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;

        // Iterate over the array
        for (int i = 1; i < n; i++) {
            // update ans with maximum sum of current and previous element
            ans = Math.max(arr[i] + arr[i - 1], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 5, 6 };
        System.out.println(maxScore(arr));
    }
}