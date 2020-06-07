本周学习了递归 , 回溯 以及 分治算法思想 , 这三个算法思想本质上都归于 递归 , 只要熟练掌握 递归 的思路 , 借用 盗梦空间 的想法 , 就很容易找到问题的最近重复性 , 如果具体点来说 , 就是把 递归 的模板记忆下来 , 映在脑海中 ! 

```java
public void recrusion(int level, int maxDepth, Object... params) {
    // terminator
    if (level > maxDepth) {
        // save data
        return ;
    }
    // process data
    
    // drill down
    
    //clean state (if necessary)
}
```

PS : 由于去实习了 , 所以平时没有太多时间 , 所以已经是尽力抽出时间了 , 老师的课看一遍如醍醐灌顶 , 后面我会多次反复观看 ! 