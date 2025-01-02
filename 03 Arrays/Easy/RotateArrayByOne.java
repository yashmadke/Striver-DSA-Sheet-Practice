public class RotateArrayByOne {
    public static void brute(int[] arr, int n) {
        int temp[] = new int[n];

        for (int i = 1; i < n; i++) {
            temp[i - 1] = arr[i];
        }

        temp[n - 1] = arr[0];

        for (int i = 0; i < n; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    public static void optimal(int[] arr, int n) {
        int temp = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        arr[n - 1] = temp;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = 5;

        // brute(arr, n);

        optimal(arr, n);
    }
}