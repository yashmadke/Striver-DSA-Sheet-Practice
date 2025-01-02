import java.util.Arrays;

class Brute {
    public static void brute(int[] arr, int n) {
        if (n == 0 || n == 1) {
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }

        Arrays.sort(arr);

        int small = arr[1];
        int large = arr[n - 2];

        System.out.println(small);
        System.out.println(large);
    }
}

class Better {
    public static void better(int[] arr, int n) {
        if (n == 0 || n == 1) {
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }

        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            small = Math.min(small, arr[i]);
            large = Math.max(large, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < secondSmall && arr[i] != small) {
                secondSmall = arr[i];
            }

            if (arr[i] > secondLarge && arr[i] != large) {
                secondLarge = arr[i];
            }
        }

        System.out.println(secondSmall);
        System.out.println(secondLarge);
    }
}

class Optimal {
    public static int secondSmallest(int[] arr, int n) {
        if (n < 2) {
            return -1;
        }

        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }

        return second_small;
    }

    public static int secondLargest(int[] arr, int n) {
        if (n < 2) {
            return -1;
        }

        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }

        return second_large;
    }
}

public class SecondLargestSmallest {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 7, 5 };
        int n = arr.length;

        // Brute.brute(arr, n);

        // Better.better(arr, n);

        System.out.println(Optimal.secondSmallest(arr, n));
        System.out.println(Optimal.secondLargest(arr, n));
    }
}