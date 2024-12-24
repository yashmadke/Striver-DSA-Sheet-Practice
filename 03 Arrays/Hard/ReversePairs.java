public class ReversePairs {
    public static int brute(int[] a, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > 2 * a[j]) {
                    count++;
                }
            }
        }

        return count++;
    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 2, 3, 1 };
        int n = 5;

        int count = brute(a, n);

        System.out.println(count);
    }
}