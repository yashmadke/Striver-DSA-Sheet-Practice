import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static List<Integer> nextPermutation(List<Integer> A) {
        int n = A.size();

        // find the break point
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                index = i;
                break;
            }
        }

        // if break point doesn't exist
        if (index == -1) {
            Collections.reverse(A);
            return A;
        }

        // find the next greater element ans swap it with index
        for (int i = n - 1; i > index; i--) {
            if (A.get(i) > A.get(index)) {
                int temp = A.get(i);
                A.set(i, A.get(index));
                A.set(index, temp);
                break;
            }
        }

        // reverse the right half
        List<Integer> sublist = A.subList(index + 1, n);
        Collections.reverse(sublist);

        return A;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(new Integer[] { 2, 1, 5, 4, 3, 0, 0 });
        List<Integer> ans = nextPermutation(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");
    }
}