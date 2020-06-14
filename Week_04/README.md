学习笔记

# 1. 二分查找代码模板

```java
public void binarySearch(int x, int start, int end) {
    if (start > end) {
        return ;
    }
    int lo = start, hi = end;
    while (lo <= hi) {
        int mid = lo + ((hi - lo) >> 1);
        if (nums[mid] == x) {
            // process logic
        } else if (nums[mid] > x) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
}
```

# 2. DFS 代码模板

```java
public int[] data = {1,2,3,4,5,6,7,8}
public boolean[] isVisited = new boolean[data.length];

public void dfs(int level, int maxDepth) {
    // terminator
    if (level > maxDepth) {
        // operation
        return ;
    }
    for (int i = 0; i < data.length; i++) {
        // process logic
        if (isVisited[i]) {
        	continue;
    	}
        isVisited[i] = true;
        // drill down
        dfs(level + 1, maxDepth);
        // revert the current level state
        isVisited[i] = false;
    }
}
```

# 3. BFS 代码模板

```java
public void bfs() {
    Deque<Integer> queue = new LinkedList<>();
    queue.offer(node);
    while (!queue.isEmpty()) {
        node = queue.pollFirst();
        // process logic
        res.add(node.val);
        // next level
        for (Node child : node.children) {
            queue.offerLast(child);
        }
    }
}
```

# 4. 贪心算法

有一句话说的很对 : "贪心思想的人生不一定完美 , 动态规划的人生一定是最棒的 ! "

这句话就很好的区别开 贪心算法 和 动态规划了

贪心算法就是贪图眼前利益 , 不估计长远利益 , 每一步都选对自己最有利的 , 但是到最后却不一定是达到最好的结果

而动态规划就是把之前走过的路都记忆下来 , 遇到下一步时 , 回过头去看自己都过的路 , 去思考往哪里走才能有可能达到整个结局的最优 , 所以动态规划是会"反省"自己的 , 而贪心算法则是莽夫