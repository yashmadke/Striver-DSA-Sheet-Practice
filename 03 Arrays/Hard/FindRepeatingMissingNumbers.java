public class FindRepeatingMissingNumbers {
    public static int[] brute(int[] a) {
        int n = a.length;
        int repeating = -1, missing = -1;

        // find repeating and missing number
        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (a[j] == i) {
                    count++;
                }
            }

            if (count == 2) {
                repeating = i;
            } else if (count == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        int[] ans = { repeating, missing };

        return ans;
    }

    public static int[] better(int[] a) {
        int n = a.length;
        int[] hash = new int[n + 1];

        // update the hash array
        for (int i = 0; i < n; i++) {
            hash[a[i]]++;
        }

        int repeating = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        int[] ans = { repeating, missing };

        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 3, 1, 2, 5, 4, 6, 7, 5 };

        // int ans[] = brute(a);
        int ans[] = better(a);

        System.out.println(ans[0] + ", " + ans[1]);
    }
}