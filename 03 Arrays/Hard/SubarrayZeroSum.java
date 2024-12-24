import java.util.*;;

public class SubarrayZeroSum {
    public static int brute(int[] a) {
        int max = 0;

        for (int i = 0; i < a.length; ++i) {
            int sum = 0;

            for (int j = i; j < a.length; ++j) {
                sum += a[j];

                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    public static int optimal(int[] A, int n) {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.get(sum) != null) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {
                    mpp.put(sum, i);
                }
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int a[] = { 9, -3, 3, -1, 6, -5 };

        // System.out.println(brute(a));
        System.out.println(optimal(a, a.length));
    }
}