//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果任意一条链表为空，返回另外一条链表
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            // l1 的 下一节点是 l1.next 的链表和 l2 合并后的头节点
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            // l2 的 下一节点是 l2.next 为头节点的链表和 l1 合并后的头节点
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
