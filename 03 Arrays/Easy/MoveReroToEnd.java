import java.util.ArrayList;

public class MoveReroToEnd {
    // public static int[] moveZeros(int n, int[] arr) {
    // ArrayList<Integer> temp = new ArrayList<>();

    // for (int i = 0; i < n; i++) {
    // if (arr[i] != 0) {
    // temp.add(arr[i]);
    // }
    // }

    // int nz = temp.size();

    // for (int i = 0; i < nz; i++) {
    // arr[i] = temp.get(i);
    // }

    // for (int i = nz; i < n; i++) {
    // arr[i] = 0;
    // }

    // return arr;
    // }

    public static int[] moveZeros(int n, int[] nums) {
        int j = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) {
            return nums;
        }

        for (int i = j + 1; j < nums.length; j++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        int n = 10;

        int[] ans = moveZeros(n, arr);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}