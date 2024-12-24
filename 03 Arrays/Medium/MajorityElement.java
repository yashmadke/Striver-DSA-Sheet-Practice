import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int better(int[] v) {
        int n = v.length;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        // storing the element with its occurence
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);
        }

        // searching for majority element
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }

        return -1;
    }

    // Moore's voting algorithm
    public static int optimal(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        // checking if the stored element is majority element
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element) {
                count1++;
            }
        }

        if (count1 > (n / 2)) {
            return element;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };

        // int ans = better(arr);
        int ans = optimal(arr);

        System.out.println("The majority element is: " + ans);
    }
}