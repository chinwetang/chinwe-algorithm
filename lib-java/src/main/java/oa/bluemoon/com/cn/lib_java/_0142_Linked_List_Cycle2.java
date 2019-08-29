package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mHead = [3,2,0,-4], pos = 1
 * 输出：mTail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：mHead = [1,2], pos = 0
 * 输出：mTail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：mHead = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class _0142_Linked_List_Cycle2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    static class Solution {
        public ListNode detectCycle(ListNode mHead) {
            ListNode slow = mHead, quick = mHead;
            while (quick != null && quick.next != null && quick.next.next != null) {
                slow = slow.next;
                quick = quick.next.next;
                if (slow == quick) {
                    ListNode p1 = mHead, p2 = slow;
                    while (p1 != p2) {
                        p1 = p1.next;
                        p2 = p2.next;
                    }
                    return p1;
                }
            }
            return null;
        }
    }
}
