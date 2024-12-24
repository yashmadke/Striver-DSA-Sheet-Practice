import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static int nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return (int) res;
    }

    // variation 1
    public static int variation1(int row, int column) {
        int element = (int) nCr(row - 1, column - 1);

        return element;
    }

    // variation 2
    public static void bruteForce(int n) {
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }

    public static void optimal(int n) {
        long ans = 1;
        System.out.print(ans + " ");

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;

            System.out.print(ans + " ");
        }

        System.out.println();
    }

    // variation 3
    public static List<List<Integer>> bruteFOrce(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>();

            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }

            ans.add(tempLst);
        }

        return ans;
    }

    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;

            ansRow.add((int) ans);
        }

        return ansRow;
    }

    public static List<List<Integer>> oPtimal(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }

        return ans;
    }

    public static void main(String[] args) {
        // variation 1
        int row = 5;
        int column = 3;

        int element = variation1(row, column);

        // System.out.println(element);

        // variation 2
        int n = 5;
        // bruteForce(n);
        // optimal(n);

        // variation 3
        // List<List<Integer>> ans = bruteFOrce(n);
        List<List<Integer>> ans = oPtimal(n);

        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }

            System.out.println();
        }
    }
}