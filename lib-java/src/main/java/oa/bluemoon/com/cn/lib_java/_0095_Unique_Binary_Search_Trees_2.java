package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0095_Unique_Binary_Search_Trees_2 {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new Solution().generateTrees(3);
    }

    static class Solution {

        Map<List<Integer>, List<TreeNode>> map = new HashMap<>();

        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> value = new ArrayList<>();
            value.add(null);
            map.put(new ArrayList<Integer>(), value);
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            return generateTrees(list);
        }

        public List<TreeNode> generateTrees(List<Integer> list) {
            List<TreeNode> nodeList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                List<Integer> leftKey = new ArrayList<>(list.subList(0, i));
                List<Integer> rightKey = new ArrayList<>(list.subList(i + 1, list.size()));
                List<TreeNode> leftNodeList = map.get(leftKey);
                List<TreeNode> rightNodeList = map.get(rightKey);
                if (leftNodeList == null) {
                    leftNodeList = generateTrees(leftKey);
                }
                if (rightNodeList == null) {
                    rightNodeList = generateTrees(rightKey);
                }
                for (TreeNode leftTreeNode : leftNodeList) {
                    for (TreeNode rightTreeNode : rightNodeList) {
                        TreeNode node = new TreeNode(list.get(i));
                        node.left = leftTreeNode;
                        node.right = rightTreeNode;
                        nodeList.add(node);
                    }
                }
            }
            map.put(list, nodeList);
            return nodeList;
        }
    }


    static class Solution2 {


        Map<String, List<TreeNode>> map = new HashMap<>();

        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<>();
            return generateTrees(1, n + 1);
        }

        public List<TreeNode> generateTrees(int from, int to) {
            List<TreeNode> value = new ArrayList<>();
            if (from == to) {
                value.add(null);
            } else {
                for (int i = from; i < to; i++) {
                    String leftKey = from + "-" + i;
                    String rightKey = (i + 1) + "-" + to;
                    List<TreeNode> leftNodeList = map.get(leftKey);
                    List<TreeNode> rightNodeList = map.get(rightKey);
                    if (leftNodeList == null) {
                        leftNodeList = generateTrees(from, i);
                    }
                    if (rightNodeList == null) {
                        rightNodeList = generateTrees(i + 1, to);
                    }
                    for (TreeNode leftTreeNode : leftNodeList) {
                        for (TreeNode rightTreeNode : rightNodeList) {
                            TreeNode node = new TreeNode(i);
                            node.left = leftTreeNode;
                            node.right = rightTreeNode;
                            value.add(node);
                        }
                    }
                }

            }
            map.put(from + "-" + to, value);
            return value;
        }

    }
}
