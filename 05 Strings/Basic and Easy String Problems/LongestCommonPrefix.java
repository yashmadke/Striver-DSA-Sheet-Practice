public class LongestCommonPrefix {
    public static String optimal(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0]; // initialize the prefix with the first string

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) { // check if the current string starts with the prefix
                prefix = prefix.substring(0, prefix.length() - 1); // shorten the prefix

                if (prefix.isEmpty()) { // if prefix becomes empty, return ""
                    return "";
                }
            }
        }

        return prefix; // return the common prefix
    }

    public static void main(String[] args) {
        String[] strs1 = { "flower", "flow", "flight" };
        String[] strs2 = { "dog", "racecar", "car" };
        String[] strs3 = { "interspecies", "interstellar", "interstate" };

        LongestCommonPrefix obj = new LongestCommonPrefix();

        System.out.println(obj.optimal(strs1));
        System.out.println(obj.optimal(strs2));
        System.out.println(obj.optimal(strs3));
    }
}