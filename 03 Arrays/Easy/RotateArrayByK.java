import java.util.ArrayList;

public class RotateArrayByK {
    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateLeft(ArrayList<Integer> arr, int n, int k) {
        k = k % n;
        if (k == 0) {
            return;
        }

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            temp.add(arr.get(i));
        }

        for (int i = k; i < n; i++) {
            arr.set(i - k, arr.get(i));
        }

        for (int i = n - k; i < n; i++) {
            arr.set(i, temp.get(i - (n - k)));
        }
    }

    public static void rotateRight(int[] arr, int k) {
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);
        // arr.add(6);
        // arr.add(7);

        // rotateLeft(arr, arr.size(), 3);

        // for (int num : arr) {
        // System.out.print(num + " ");
        // }

        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        rotateRight(arr, 3);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}