public class CountInversions {
    public static int brute(int[] a, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = { 5, 4, 3, 2, 1 };
        int n = 5;

        int count = brute(a, n);

        System.out.println(count);
    }
}