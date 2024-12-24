public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        for (int i = 0; i <= n - 1; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void recursiveInsertionSort(int[] arr, int i, int n) {
        if (i == n) {
            return;
        }

        int j = i;

        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        recursiveInsertionSort(arr, i + 1, n);
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        int n = arr.length;

        recursiveInsertionSort(arr, 0, n);

        System.out.println("Sorted array is:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}