import java.util.Stack;

public class ReverseWordsInString {
    public static String brute(String s) {
        Stack<String> st = new Stack<>();
        int i;
        String str = "";

        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!str.isEmpty()) {
                    st.push(str);
                    str = "";
                }
            } else {
                str += s.charAt(i);
            }
        }

        // push the last word if any
        if (!str.isEmpty()) {
            st.push(str);
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
            if (!st.isEmpty()) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    public static String optimal(String s) {
        int left = 0;
        int right = s.length() - 1;

        String temp = "";
        String ans = "";

        while (left <= right) {
            char ch = s.charAt(left);

            if (ch != ' ') {
                temp += ch;
            } else if (ch == ' ') {
                if (!ans.equals("")) {
                    ans = temp + " " + ans;
                } else {
                    ans = temp;
                }

                temp = "";
            }

            left++;
        }

        if (!temp.equals("")) {
            if (!ans.equals("")) {
                ans = temp + " " + ans;
            } else {
                ans = temp;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "This is decent";
        // System.out.println(brute(s));
        System.out.println(optimal(s));
    }
}