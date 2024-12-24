import java.util.Arrays;

public class MergedSortedArraysWithoutExtraSpace {
    public static void brute(long[] arr1, long[] arr2, int n, int m) {
        long[] arr3 = new long[n + m];
        int left = 0;
        int right = 0;
        int index = 0;

        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                arr3[index] = arr1[left];
                index++;
                left++;
            } else {
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }

        while (left < n) {
            arr3[index++] = arr1[left++];
        }

        while (right < m) {
            arr3[index++] = arr2[right++];
        }

        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - n] = arr3[i];
            }
        }
    }

    public static void optimal1(long[] arr1, long[] arr2, int n, int m) {
        // declare 2 pointers
        int left = n - 1;
        int right = 0;

        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void optimal2(long[] arr1, long[] arr2, int n, int m) {
        int len = n + m;

        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // 2 pointers
            int left = 0;
            int right = left + gap;

            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                } else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                } else {
                    swapIfGreater(arr1, arr1, left, right);
                }

                left++;
                right++;
            }

            if (gap == 1) {
                break;
            }

            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void main(String[] args) {
        long[] arr1 = { 1, 4, 8, 10 };
        long[] arr2 = { 2, 3, 9 };
        int n = 4, m = 3;

        // brute(arr1, arr2, n, m);
        // optimal1(arr1, arr2, n, m);
        optimal2(arr1, arr2, n, m);

        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}