package oa.bluemoon.com.cn.lib_java;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MyClass {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }

    ListNode newListNode;

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        } else {
            int n = rotateRight(head, head, k);
            if(n==k){
                return head;
            }else{
                if(n<k){
                    rotateRight(head, head, k%n);
                }
                return newListNode;
            }
        }
    }

    public int rotateRight(ListNode head, ListNode node, int k) {
        if (node.next == null) {
            node.next = head;
            return 1;
        } else {
            int m = rotateRight(head, node.next, k);
            if (m == k) {
                newListNode = node.next;
                node.next = null;
            }
            return m + 1;
        }
    }
}
