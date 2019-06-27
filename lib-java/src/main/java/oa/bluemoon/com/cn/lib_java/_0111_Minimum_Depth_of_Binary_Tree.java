package oa.bluemoon.com.cn.lib_java;

import java.util.Stack;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class _0111_Minimum_Depth_of_Binary_Tree {
    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            int minLength = -1;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode node = null;
            boolean isEnd = false;
            while (!stack.empty()) {
                if (stack.peek().left != null && (node == null || node != stack.peek().left)) {
                    stack.push(stack.peek().left);
                } else if ((stack.peek().right != null)) {
                    stack.push(stack.peek().right);
                } else {
                    isEnd = true;
                }
                if (!isEnd && minLength > 0 && stack.size() >= minLength) {
                    isEnd = true;
                }
                if (isEnd) {
                    minLength = minLength == -1 ? stack.size() : Math.min(minLength, stack.size());
                    do {
                        node = stack.pop();
                    } while (!stack.empty() && (stack.peek().right == null || stack.peek().right == node));
                    isEnd = false;
                }
            }
            return minLength - 1;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
