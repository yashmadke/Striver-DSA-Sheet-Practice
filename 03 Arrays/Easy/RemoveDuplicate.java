public class RemoveDuplicate {
    public static int remove(int[] arr) {
        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 3, 3 };

        System.out.println(remove(arr));
    }
}