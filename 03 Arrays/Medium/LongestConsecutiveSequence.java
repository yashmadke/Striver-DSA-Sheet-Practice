import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int better(int[] a) {
        int n = a.length;

        if (n == 0) {
            return 0;
        }

        // sort the array
        Arrays.sort(a);

        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        // find longest sequence
        for (int i = 0; i < n; i++) {
            if (a[i] - 1 == lastSmaller) {
                count += 1;
                lastSmaller = a[i];
            } else if (a[i] != lastSmaller) {
                count = 1;
                lastSmaller = a[i];
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static int optimal(int[] a) {
        int n = a.length;

        if (n == 0) {
            return 0;
        }

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all elements in the set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int count = 1;
                int x = it;

                while (set.contains(x + 1)) {
                    x = x + 1;
                    count = count + 1;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] a = { 100, 200, 1, 2, 3, 4 };

        // int ans = better(a);
        int ans = optimal(a);

        System.out.println("The longest consecutive sequence is " + ans);
    }
}