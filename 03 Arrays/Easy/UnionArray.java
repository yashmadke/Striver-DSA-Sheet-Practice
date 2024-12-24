import java.util.ArrayList;

public class UnionArray {
    public static ArrayList<Integer> union(int[] a, int[] b) {
        int i = 0, j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != a[i]) {
                    union.add(a[i]);
                }

                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != b[j]) {
                    union.add(b[j]);
                }

                j++;
            }
        }

        while (i < a.length) {
            if (union.get(union.size() - 1) != a[i]) {
                union.add(a[i]);
            }

            i++;
        }

        while (j < b.length) {
            if (union.get(union.size() - 1) != b[j]) {
                union.add(b[j]);
            }

            j++;
        }

        return union;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

        ArrayList<Integer> union = union(arr1, arr2);

        for (int num : union) {
            System.out.print(num + " ");
        }
    }
}