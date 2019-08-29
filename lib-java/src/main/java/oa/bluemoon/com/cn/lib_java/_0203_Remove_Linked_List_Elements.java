package oa.bluemoon.com.cn.lib_java;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class _0203_Remove_Linked_List_Elements {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode nHead = new ListNode(0);
            nHead.next = head;
            ListNode node = nHead;
            while (node.next != null) {
                if (node.next.val == val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return nHead.next;
        }
    }
}
