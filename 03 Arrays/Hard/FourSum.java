import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class FourSum {
    public static List<List<Integer>> brute(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }

    public static List<List<Integer>> better(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();

                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];

                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        set.add(temp);
                    }

                    hashset.add((long) nums[k]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }

    public static List<List<Integer>> optimal(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // avoid duplicates while moving i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                // avoid duplicates while moving j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 2 pointers
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 2, 1, 3 };
        int target = 8;

        List<List<Integer>> ans = better(nums, target);

        for (List<Integer> it : ans) {
            System.out.print("[");

            for (int ele : it) {
                System.out.print(ele + " ");
            }

            System.out.print("] ");
        }

        System.out.println();
    }
}