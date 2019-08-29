package oa.bluemoon.com.cn.lib_java;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0092_Reverse_Linked_List_II {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new _0092_Reverse_Linked_List_II().reverseBetween(head, 2, 4);
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node;
            node = node.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null || head.next == null)
            return head;
        ListNode mPre = null, mP = null, nP = null, node = null;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                mPre = mPre == null ? head : mPre.next;
            } else if (i == m) {
                node = mP = mPre == null ? head : mPre.next;
            }
            if (i >= m && i <= n) {
                ListNode temp = node;
                node = node.next;
                temp.next = nP;
                nP = temp;
            }
        }
        mP.next = node;
        if (mPre == null) {
            return nP;
        } else {
            mPre.next = nP;
            return head;
        }
    }
}
