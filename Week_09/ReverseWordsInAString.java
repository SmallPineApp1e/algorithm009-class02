import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Zeng
 * @date 2020/7/18 9:08
 */
public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        s = s.trim();
        List<String> words = Arrays.asList(s.split(" +"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = reverseWords("I am the king of Bug!");
        System.out.println(s);
    }

}
