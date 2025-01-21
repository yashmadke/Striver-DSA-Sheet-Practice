public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (openCount > 0) {
                    result.append(c);
                }

                openCount++;
            } else if (c == ')') {
                openCount--;

                if (openCount > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses solution = new RemoveOutermostParentheses();
        System.out.println(solution.removeOuterParentheses("(()())(())"));
    }
}