import java.util.HashMap;

public class TwoSum {
    public static String twoSum(int n, int[] book, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = book[i];
            int moreNeeded = target - num;

            if (mpp.containsKey(moreNeeded)) {
                return "YES";
            }

            mpp.put(book[i], i);
        }

        return "NO";
    }

    public static void main(String[] args) {
        int n = 5;
        int[] book = { 2, 6, 5, 8, 11 };
        int target = 14;

        String ans = twoSum(n, book, target);

        System.out.println("This is the answer for variant 1: " + ans);
    }
}