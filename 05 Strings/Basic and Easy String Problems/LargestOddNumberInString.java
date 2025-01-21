public class LargestOddNumberInString {
    public static String optimal(String num) {
        // traverse the string from an end to find large odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);

            if ((c - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String num1 = "52";
        String num2 = "4206";
        String num3 = "35427";

        System.out.println(optimal(num1));
        System.out.println(optimal(num2));
        System.out.println(optimal(num3));
    }
}