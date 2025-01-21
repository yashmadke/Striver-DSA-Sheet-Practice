import java.util.HashMap;

public class IsomorphicString {
    public static boolean optimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // check if there is a conflicting mapping in s->t
            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) {
                    return false;
                }
            } else {
                mapST.put(c1, c2);
            }

            // check if there is a conflicting mapping in t->s
            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1) {
                    return false;
                }
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicString obj = new IsomorphicString();

        System.out.println(obj.optimal("egg", "add"));
        System.out.println(obj.optimal("foo", "bar"));
        System.out.println(obj.optimal("paper", "title"));
    }
}