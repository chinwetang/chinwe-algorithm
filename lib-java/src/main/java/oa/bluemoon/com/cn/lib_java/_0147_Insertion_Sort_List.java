package oa.bluemoon.com.cn.lib_java;

/**
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 *  
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0147_Insertion_Sort_List {
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

    static class Solution {

        public static void main(String[] args) {
            ListNode head = new ListNode(4);
            head.next = new ListNode(2);
            head.next.next = new ListNode(1);
            head.next.next.next = new ListNode(3);
            new Solution().insertionSortList(head);
        }

        public ListNode insertionSortList(ListNode head) {
            ListNode nullHead = new ListNode(0);
            nullHead.next = head;
            ListNode node = nullHead;
            while (node.next != null) {
                int val = node.next.val;
                ListNode nnh = nullHead;
                while (nnh.next.val <= val && nnh.next != node.next) {
                    nnh = nnh.next;
                }
                if(nnh.next == node.next){
                    node = node.next;
                }else{
                    ListNode currentNode = node.next;
                    node.next = node.next.next;
                    currentNode.next = nnh.next;
                    nnh.next = currentNode;
                }
            }
            return nullHead.next;
        }
    }
}
