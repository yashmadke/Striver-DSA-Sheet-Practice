import java.util.Arrays;

public class LargestElement {
    public static int brute(int[] arr) {
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }

    public static int optimal(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };

        // System.out.println(brute(arr));
        System.out.println(optimal(arr));
    }
}