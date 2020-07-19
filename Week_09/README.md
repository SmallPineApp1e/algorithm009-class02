# 第9周 第19课 | 高级动态规划

## 1. 动态规划复习

递归：函数自己调用自己的一个过程，代码模板熟记于心

```Java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return ;
    }
    // process current logic
    process(level, param);
    // drill down
    recur(level + 1, newParam);
    //restore current status
}
```

分治：分而治之，通常也是用递归进行实现，代码模板如下

```JAVA
def divide_conquer(problem, param1, param2, ···)
    # recrusion terminator
    if problem is None: 
        print_result
        return 
    
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ···)
    subresult2 = self.divide_conquer(subproblems[1], p2, ···)
    subresult3 = self.divide_conquer(subproblems[2], p3, ···)
    
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ···)
    
    # revert the current level states
```

切记：

（1）人肉递归低效且很累

（2）找到最近最简方法，将其拆解为可重复性的理解

（3）数学归纳法思维

原因在于：**计算机指令集只能执行一些可重复性的内容，因为计算机指令只有if-else、while、for-loop这一些分支和循环指令**

**动态规划的定义：**

（1）将一个问题分解为许多重复的子问题

（2）分治 + 最优子结构

（3）顺推形式：动态递推

动态规划的的代码模板：

```Java
function DP(): 
    dp = [][] # 二维情况
  
  for i = 0..M {
    for j = 0..N {
        dp[i][j] = _Function(dp[i'][j']) # 状态转移方程
    }
  }
```

动态规划的难点：

（1）状态定义，即定义dp数组时，内部每一个元素代表什么含义

（2）状态转移方程，即上一个状态如何转移到下一个状态

**关键点：**

**（1）动态规划与递归或者分治没有本质上的区别（关键看是否有最优子结构）**

**（2）共性：找到重复子问题，化繁为简**

### 常见的动态规划题目和状态转移方程

（1）[爬楼梯问题](https://leetcode-cn.com/problems/climbing-stairs/)

![image.png](https://cdn.nlark.com/yuque/0/2020/png/1694029/1594565143542-153e3f0e-49e9-483e-83ed-6b4218ab8998.png)

（2）[不同路径问题](https://leetcode-cn.com/problems/unique-paths/)

![image.png](https://cdn.nlark.com/yuque/0/2020/png/1694029/1594565226694-8de5d70c-9c03-429e-af07-dbc2ec860657.png)

（3）[打家劫舍问题](https://leetcode-cn.com/problems/climbing-stairs/)

![image.png](https://cdn.nlark.com/yuque/0/2020/png/1694029/1594565312108-083fe2fc-dcb6-4d85-88dc-bcd4d0376ff4.png)

（4）[最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

![image.png](https://cdn.nlark.com/yuque/0/2020/png/1694029/1594565631616-1dc42df6-7a30-477c-af6f-be9e91faaafc.png)

（5）[股票买卖问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

![image.png](https://cdn.nlark.com/yuque/0/2020/png/1694029/1594565764838-b431d725-79c6-409c-9e62-3d24ff9a0046.png)

![image.png](https://cdn.nlark.com/yuque/0/2020/png/1694029/1594565778059-4064dacc-c25c-428e-ab2f-a47cf206efe0.png)