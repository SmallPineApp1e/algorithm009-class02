# 第7周 第13课 | 字典树和并查集

Trie树的实现模板（Java版）

```java
/**
 * @author Zeng
 * @date 2020/7/4 22:57
 */
public class Trie {

    boolean isEnd;
    Trie[] trie;

    /** Initialize your data structure here. */
    public Trie() {
        trie = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        Trie root = this;
        for (char ch : arr) {
            if (root.trie[ch - 'a'] == null) {
                root.trie[ch - 'a'] = new Trie();
            }
            root = root.trie[ch - 'a'];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        Trie root = this;
        for (char ch : arr) {
            root = root.trie[ch - 'a'];
            if (root == null) return false;
        }
        return root.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        Trie root = this;
        for (char ch : arr) {
            root = root.trie[ch - 'a'];
            if (root == null) return false;
        }
        return true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

}
```

# 第7周 第14课 | 高级搜索

DFS 模板（Java版）：

```java
public void dfs(int level, int param) {
    // terminator
    if (level > max) {
        return ;
    }
    // process logic
    data = process(param);
    // drill down
    dfs(level + 1, param);
    // restore state
}
```

BFS模板（Java版）：

```java
public void bfs(Object param) {
    List<Object> queue = new LinkedList<>();
    queue.add(param);
    while (!queue.isEmpty()) {
        param = queue.poll();
        // process logic
        process(param);
        // 扩散
        nextParam = param.next();
        queue.add(nextParam);
    }
}
```

高级搜索的本质：**剪枝**，传统的 DFS 和 BFS 缺点在于，当画出递归树后，发现有很多分枝在某一个非叶子节点上，就可以排除掉该节点以后的所有分支，但是在代码中没有将它们提前地过滤掉，导致程序**不断地递归遍历无用的分支**，提高了程序的时间复杂度。

**剪枝的意义：提早发现那些没有意义的节点，阻止程序在这些节点上往下递归。**

所以，要做的只有一步：在 drill down 之前，判断该节点**是否值得 drill down**。如果已经不满足条件了，那就把该节点之后的所有节点都砍掉。

双向BFS模板（Java版）：

```java
public void bothwayBfs(Object start, Object end) {
    // 灵魂
    Deque<Object> startQueue = new LinkedList<>();
    Deque<Object> endQueue = new LinkedList<>();
    startQueue.offerLast(start);
    endQUeue.offerLast(end);
    while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
        // 节点少的一边作扩散
        if (startQueue.size() > endQueue.size()) {
            swap(startQueue, endQueue);
        }
        int size = startQueue.size();
        while (size-- > 0) {
            start = startQueue.pollFirst();
            // terminator 双向BFS的终结点
            if (endQueue.contains(start)) {
                // note
                return ;
            }
            // 数据处理
            process(start);
            start = start.next();
            // 扩散到下一层
            startQueue.offerLast(start);
        }
    }
}
```

# 第7周 第15课 | AVL树和红黑树

复习知识：

树的三种遍历方式：前序遍历（根-左-右）、中序遍历（左-根-右）、后序遍历（左-右-根）

二叉搜索树的两个特性：

1. **左子树**永远小于根节点的值，**右子树**永远大于根节点的值
2. **中序遍历是升序的**

红黑树是一种**近似平衡**的二叉搜索树，能够确保任何一个节点的左右子树的**高度差小于2倍**，红黑树满足下列条件：

1. 每个节点要么是黑色，要么是红色
2. 根节点是黑色
3. 每个叶子节点是黑色的
4. 不能有两个相邻的红色节点
5. 从任一节点到其每个叶子节点的所有路径都包含相同数目的黑色节点