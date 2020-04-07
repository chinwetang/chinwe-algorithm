package oa.bluemoon.com.cn.lib_java;

import java.util.List;
import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 *  
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0445_Add_Two_Numbers_II {

    public static void main(String[] args) {

        ListNode l1 = create(new int[]{7, 2, 4, 3});
        ListNode l2 = create(new int[]{5, 6, 4});

        new Solution().addTwoNumbers(l1, l2);
    }


    private static ListNode create(int[] values) {
        ListNode node = null;
        for (int i = values.length - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(values[i]);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node1 = l1;
            ListNode node2 = l2;
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            while (node1 != null) {
                stack1.push(node1);
                node1 = node1.next;
            }
            while (node2 != null) {
                stack2.push(node2);
                node2 = node2.next;
            }
            ListNode result = null;
            int bit = 0;
            for (; ; ) {
                if (stack1.empty() && stack2.empty())
                    break;
                int v1 = 0, v2 = 0;
                if (!stack1.empty())
                    v1 = stack1.pop().val;
                if (!stack2.empty())
                    v2 = stack2.pop().val;
                int v = bit + v1 + v2;
                bit = v / 10;
                v = v % 10;
                ListNode newNode = new ListNode(v);
                newNode.next = result;
                result = newNode;
            }
            if (bit > 0) {
                ListNode newNode = new ListNode(bit);
                newNode.next = result;
                result = newNode;
            }
            return result;
        }
    }


    static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node1 = l1;
            ListNode node2 = l2;
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            while (node1 != null) {
                stack1.push(node1);
                node1 = node1.next;
            }
            while (node2 != null) {
                stack2.push(node2);
                node2 = node2.next;
            }
            ListNode result = null;
            int bit = 0;
            for (; ; ) {
                if (stack1.empty() && stack2.empty())
                    break;
                int v1 = 0, v2 = 0;
                if (!stack1.empty())
                    v1 = stack1.pop().val;
                if (!stack2.empty())
                    v2 = stack2.pop().val;
                int v = bit + v1 + v2;
                bit = v / 10;
                v = v % 10;
                ListNode newNode = new ListNode(v);
                newNode.next = result;
                result = newNode;
            }
            if (bit > 0) {
                ListNode newNode = new ListNode(bit);
                newNode.next = result;
                result = newNode;
            }
            return result;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
