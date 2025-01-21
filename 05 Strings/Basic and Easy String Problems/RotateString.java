public class RotateString {
    public static boolean optimal(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String doubled = s + s;

        return doubled.contains(goal);
    }

    public static void main(String[] args) {
        RotateString obj = new RotateString();

        System.out.println(obj.optimal("abcde", "cdeab"));
        System.out.println(obj.optimal("abcde", "abced"));
    }
}