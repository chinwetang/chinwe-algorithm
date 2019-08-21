package oa.bluemoon.com.cn.lib_java;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0234_Palindrome_Linked_List {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null)
                return true;
            //last 是记录median的上一个，用于反转
            ListNode last = null;
            //median是慢指针，一次走一步，最后落在中点或中点偏左的位置
            ListNode median = head;
            //end是快指针，一次走两步，其意义是当其到底时median恰好在中点或偏左
            ListNode end = head;
            while (end.next != null && end.next.next != null) {
                end = end.next.next;
                ListNode temp = median;
                median = median.next;
                temp.next = last;
                last = temp;
            }
            ListNode left = null;
            ListNode right = null;
            if (end.next == null) {
                //此时median刚好在中点
                left = last;
                right = median.next;

            } else {
                //此时median靠左边
                right = median.next;
                median.next = last;
                left = median;
            }

            while (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }
    }
}
