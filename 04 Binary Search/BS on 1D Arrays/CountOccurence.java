public class CountOccurence {
    public static int brute(int[] arr, int n, int x) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
        int n = 8, x = 8;

        int ans = brute(arr, n, x);

        System.out.println(ans);
    }
}