package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0086_Partition_List {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode left = newHead;
            while (left.next != null && left.next.val < x) {
                left = left.next;
            }
            ListNode right = left;
            while (right.next != null) {
                if (right.next.val < x) {
                    ListNode pos = right.next.next;
                    right.next.next = left.next;
                    left.next = right.next;
                    right.next = pos;
                    left = left.next;
                }else{
                    right = right.next;
                }
            }
            return newHead.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
