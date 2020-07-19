import java.util.HashMap;
import java.util.Map;

/**
 * @author Zeng
 * @date 2020/7/19 10:08
 */
public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }

    public static boolean helper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic("abc", "def");
        System.out.println(isomorphic);
    }

}
