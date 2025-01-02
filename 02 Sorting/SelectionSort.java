public class SelectionSort {
    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int mI = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mI]) {
                    mI = j;
                }
            }

            // swap
            int temp = arr[mI];
            arr[mI] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 6, 2, 5, 7, 9, 1, 3 };
        int n = arr.length;

        selectionSort(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}