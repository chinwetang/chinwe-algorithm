package oa.bluemoon.com.cn.lib_java;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0023_Merge_k_Sorted_Lists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            int length = lists.length;
            for (int i = 0; i < length; ) {
                if (lists[i] == null) {
                    swap(lists, i, --length);
                }else{
                    i++;
                }
            }
            ListNode head = new ListNode(0);
            ListNode node = head;
            buildHeap(lists, length);
            while (length > 0) {
                node.next = lists[0];
                node = node.next;
                if (lists[0].next != null) {
                    lists[0] = lists[0].next;
                } else if (length == 1) {
                    break;
                } else {
                    lists[0] = lists[--length];
                }
                adjust(lists, length, 0);
            }
            return head.next;
        }

        /**
         * 调整
         *
         * @param nums
         * @param length
         * @param x
         */
        public void adjust(ListNode[] nums, int length, int x) {
            while (x <= length / 2 - 1) {
                int lP = 2 * x + 1;
                int rP = 2 * x + 2;
                int left = nums[lP].val;
                int right = left + 1;
                if (rP < length) {
                    right = nums[rP].val;
                }
                int min = Math.min(left, right);
                if (nums[x].val <= min)
                    break;
                if (min == left) {
                    ListNode temp = nums[x];
                    nums[x] = nums[lP];
                    nums[lP] = temp;
                    x = lP;
                } else {
                    ListNode temp = nums[x];
                    nums[x] = nums[rP];
                    nums[rP] = temp;
                    x = rP;
                }
            }
        }


        /**
         * 交换两个数
         *
         * @param nums
         * @param i
         * @param j
         */
        public void swap(ListNode[] nums, int i, int j) {
            if (i == j)
                return;
            ListNode temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        /**
         * 建堆
         *
         * @param nums
         */
        public void buildHeap(ListNode[] nums, int length) {
            for (int i = length / 2 - 1; i >= 0; i--) {
                adjust(nums, length, i);
            }
        }
    }
}
