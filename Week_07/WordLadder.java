import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zeng
 * @date 2020/7/5 21:47
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visitedBegin = new HashSet<>();
        Set<String> visitedEnd = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int step = 1;
        visitedBegin.add(beginWord);
        visitedEnd.add(endWord);
        while (!visitedBegin.isEmpty() && !visitedEnd.isEmpty()) {
            // 从最小的集合开始扩散
            if (visitedBegin.size() > visitedEnd.size()) {
                Set<String> temp = visitedBegin;
                visitedBegin = visitedEnd;
                visitedEnd = temp;
            }
            Set<String> nextLevelSet = new HashSet<>();
            for (String word : visitedBegin) {
                char[] originArray = word.toCharArray();
                for (int i = 0; i < originArray.length; i++) {
                    char replaced = originArray[i];
                    for (int j = 'a'; j <= 'z'; j++) {
                        if (replaced == j) {
                            continue;
                        }
                        originArray[i] = (char) j;
                        String nextWord = String.valueOf(originArray);
                        if (wordSet.contains(nextWord)) {
                            if (visitedEnd.contains(nextWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                nextLevelSet.add(nextWord);
                            }
                        }
                    }
                    originArray[i] = replaced;
                }
            }
            visitedBegin = nextLevelSet;
            step++;
        }
        return 0;
    }

}
