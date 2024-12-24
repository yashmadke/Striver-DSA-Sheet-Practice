import java.util.ArrayList;

public class IntersectionArray {
    public static ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> intersection = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                intersection.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return intersection;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

        ArrayList<Integer> intersection = intersection(arr1, arr2);

        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }
}