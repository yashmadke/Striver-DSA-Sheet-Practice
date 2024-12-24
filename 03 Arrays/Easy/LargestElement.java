public class LargestElement {
    public static int findLargest(int[] arr) {
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

        System.out.println(findLargest(arr));
    }
}