import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng
 * @date 2020/7/5 9:49
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesis(n, "", 0, 0, res);
        return res;
    }
    public void generateParenthesis(int max, String s, int left, int right, List<String> res) {
        if (left >= max && right >= max) {
            res.add(s);
            return ;
        }
        if (left < max) {
            generateParenthesis(max, s + "(", left + 1, right, res);
        }
        if (right < max && right < left) {
            generateParenthesis(max, s + ")", left, right + 1, res);
        }
    }
}
