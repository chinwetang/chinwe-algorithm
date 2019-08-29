package oa.bluemoon.com.cn.lib_java;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0206_Reverse_Linked_List {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            ListNode node = head;
            while (node != null) {
                ListNode temp = node;
                node=node.next;
                temp.next=newHead;
                newHead=temp;
            }
            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 2; i <= 5; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        new Solution2().reverseList(head);
    }

    static class Solution2 {

        public ListNode reverseList(ListNode head) {
            if (head==null||head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            ListNode next=head.next;
            head.next=null;
            next.next=head;
            return newHead;
        }
    }
}
