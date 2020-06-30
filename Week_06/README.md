# 第6周 第12课 | 动态规划

## 递归代码模板

```java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_DEPTH) {
        // collect data
        return ;
    }
    // process data
    
    //drill down
    recur(level + 1, param);
    
    // restore the current data
}
```

## 分治代码模板

```java
public void sub(problem, data) {
    if (problem == null) {
        return ;
    }
    data = prepare_data(data);
    // subproblems
    subProblems = split_problem(problem);
    result1 = sub(subProblems[0], data);
    result2 = sub(subProblems[1], data);
    result2 = sub(subProblems[2], data);
    // merge result
    result = merge(result1, result2, result3);
}
```

## 感触

1. 人肉递归很累、不准确
2. 找到最近最简方法，将其分解成许多可重复解决的问题
3. 数学归纳法思维（抵制人肉递归）

**本质：寻找重复性 -> 计算机指令集**

## 动态规划 Dynamic Programming

将一个复杂的问题分解成简单的子问题（用一种递归的方式），所以动态规划就是利用**分治+最优子结构**

动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）

**共性：找到重复子问题**

差异性：最优子结构、中途可以**淘汰**次优解

**动态规划的人生一定最完美！！！**