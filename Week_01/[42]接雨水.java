//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int curIndex = 0; curIndex < height.length; curIndex++) {
            // 判断当前柱子是否比栈顶柱子高, 如果是则说明有积水
            while (!deque.isEmpty() && height[deque.peekLast()] < height[curIndex]) {
                // 栈顶柱子的下标
                int topIndex = deque.pollLast();
                // 如果中间还有相同高度的柱子, 也弹出去, 因为相同高度的柱子的积水是相同的, 只需要计算一次
                while (!deque.isEmpty() && height[deque.peekLast()] == height[topIndex]) {
                    deque.pollLast();
                }
                // 如果栈已空, 说明左边没有柱子, 不用计算
                if (!deque.isEmpty()) {
                    // 求出积水的高度, 是 min(left_height, right_height) - cur_height
                    int depth = Math.min(height[deque.peekLast()], height[curIndex]) - height[topIndex];
                    // 求出宽度
                    int width = curIndex - deque.peekLast() - 1;
                    // 更新积水量
                    ans += depth * width;
                }
            }
            // 将当前柱子压栈
            deque.offerLast(curIndex);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
