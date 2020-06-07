//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(1, n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public void combine(int level, int n, int k, int num, List<Integer> tmp, List<List<Integer>> res) {
        // terminator
        if (level > k) {
            res.add(new ArrayList<>(tmp));
            return ;
        }
        // process logic
        for (int i = num; i <= n; i++) {
            tmp.add(i);
            // drill down
            combine(level + 1, n, k, i + 1, tmp, res);
            // clean state
            tmp.remove(tmp.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
