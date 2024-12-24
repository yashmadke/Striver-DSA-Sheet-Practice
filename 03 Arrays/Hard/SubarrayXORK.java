import java.util.HashMap;
import java.util.Map;

public class SubarrayXORK {
    public static int brute(int[] a, int k) {
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // calculate xor of all elements
                int xor = 0;

                for (int K = i; K <= j; K++) {
                    xor = xor ^ a[K];
                }

                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int better(int[] a, int k) {
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xor = 0;

            for (int j = i; j < n; j++) {
                // calculate xor of all elements
                xor = xor ^ a[j];

                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int optimal(int[] a, int k) {
        int n = a.length;
        int xor = 0;

        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(xor, 1);

        int count = 0;

        for (int i = 0; i < n; i++) {
            xor = xor ^ a[i];
            int x = xor ^ k;

            if (mpp.containsKey(x)) {
                count += mpp.get(x);
            }

            if (mpp.containsKey(xor)) {
                mpp.put(xor, mpp.get(xor) + 1);
            } else {
                mpp.put(xor, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = { 4, 2, 2, 6, 4 };
        int k = 6;

        // int ans = brute(a, k);
        // int ans = better(a, k);
        int ans = optimal(a, k);

        System.out.println(ans);
    }
}