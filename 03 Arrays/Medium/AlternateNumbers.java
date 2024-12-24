import java.util.ArrayList;

public class AlternateNumbers {
    public static int[] bruteForce(int[] a) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                positive.add(a[i]);
            } else {
                negative.add(a[i]);
            }
        }

        for (int i = 0; i < a.length / 2; i++) {
            a[2 * i] = positive.get(i);
            a[2 * i + 1] = negative.get(i);
        }

        return a;
    }

    public static int[] optimal(int[] nums) {
        int[] ans = new int[nums.length];

        int positiveIndex = 0, negativeIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[negativeIndex] = nums[i];
                negativeIndex += 2;
            } else {
                ans[positiveIndex] = nums[i];
                positiveIndex += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, -4, -5 };

        int[] ans = optimal(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}