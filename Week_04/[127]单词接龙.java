//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 改用 Set 判断字符串是否存在于列表中
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        queue.offerLast(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.pollFirst();
                char[] word_array = word.toCharArray();
                // 替换每一位上的字符, 判断是否存在于列表中, 或者是否能够到达终点
                for (int j = 0; j < word_array.length; j++) {
                    // 记录下原来的字符, 在当前位替换完所有字符后需要先替换回来, 再替换下一次
                    char replace = word_array[j];
                    for (int k = 'a'; k <= 'z'; k++) {
                        if (k == replace) continue;
                        word_array[j] = (char) k;
                        String new_str = String.valueOf(word_array);
                        if (new_str.equals(endWord) && set.contains(new_str)) {
                            return step + 1;
                        }
                        if (set.contains(new_str) && !visited.contains(new_str)) {
                            visited.add(new_str);
                            queue.offerLast(new_str);
                        }
                    }
                    word_array[j] = replace;
                }
            }
            step++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
