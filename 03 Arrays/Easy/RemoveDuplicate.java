import java.util.HashSet;

public class RemoveDuplicate {
    public static int brute(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int k = set.size();
        int j = 0;

        for (int x : set) {
            arr[j++] = x;
        }

        return k;
    }

    public static int optimal(int[] arr) {
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

        // System.out.println(brute(arr));
        System.out.println(optimal(arr));
    }
}