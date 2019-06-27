package oa.bluemoon.com.cn.lib_java;

import java.util.Stack;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class _0110_Balanced_Binary_Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        new Solution2().isBalanced(root);
    }

    static class Solution2 {

        public boolean isBalanced(TreeNode root) {
            int maxHeight = -1;
            TreeNode pushNode = null;
            Stack<TreeNode> stack = new Stack<>();
            if (root != null)
                stack.push(root);
            while (!stack.empty()) {
                TreeNode node = stack.peek();
                if (node.left != null && (pushNode == null || node.left != pushNode)) {
                    stack.push(node.left);
                } else if (node.right != null && (pushNode == null || node.right != pushNode)) {
                    stack.push(node.right);
                } else {
                    if (maxHeight == -1) {
                        maxHeight = stack.size();
                    } else if (Math.abs(maxHeight - stack.size()) > 1) {
                        return false;
                    } else {
                        maxHeight = Math.max(maxHeight, stack.size());
                    }
                    pushNode = stack.pop();
                    while (stack.peek().right == null || stack.peek().right == pushNode) {
                        pushNode = stack.pop();
                        if (stack.empty()) {
                            return true;
                        }
                    }
                }
            }
            return true;
        }

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
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return treeHeight(root) != -1;
        }

        public int treeHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = treeHeight(root.left);
            int right = treeHeight(root.right);
            if (left == -1 || right == -1) {
                return -1;
            } else if (Math.abs(left - right) < 2) {
                return Math.max(left, right) + 1;
            } else {
                return -1;
            }
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
