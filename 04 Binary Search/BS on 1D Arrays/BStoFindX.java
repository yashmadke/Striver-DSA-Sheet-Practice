public class BStoFindX {
    public static int iterative(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int recursive(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (target > nums[mid]) {
            return recursive(nums, mid + 1, high, target);
        }

        return recursive(nums, low, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] a = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 6;

        // int index = iterative(a, target);
        int index = recursive(a, 0, a.length - 1, target);

        System.out.println(index);
    }
}