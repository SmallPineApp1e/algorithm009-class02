import java.util.HashMap;
import java.util.Map;

/**
 * @author Zeng
 * @date 2020/7/18 8:28
 */
public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int len = firstUniqChar("loveleetcode");
        System.out.println(len);
    }

}
