import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public static List<Integer> bruteForce(int[] v) {
        int n = v.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || list.get(0) != v[i]) {
                int count = 0;

                for (int j = 0; j < n; j++) {
                    if (v[j] == v[i]) {
                        count++;
                    }
                }

                if (count > (n / 3)) {
                    list.add(v[i]);
                }
            }

            if (list.size() == 2) {
                break;
            }
        }

        return list;
    }

    public static List<Integer> better(int[] v) {
        int n = v.length;
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> mpp = new HashMap<>();

        int mini = (int) (n / 3) + 1;

        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);

            if (mpp.get(v[i]) == mini) {
                list.add(v[i]);
            }

            if (list.size() == 2) {
                break;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 33, 33, 11, 33, 11 };

        // List<Integer> ans = bruteForce(arr);
        List<Integer> ans = better(arr);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}