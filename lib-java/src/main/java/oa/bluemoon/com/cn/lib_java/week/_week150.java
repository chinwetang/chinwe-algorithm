package oa.bluemoon.com.cn.lib_java.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2019/08/18
 */
public class _week150 {

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

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(989);
//        root.right = new TreeNode(10250);
//        root.right.left = new TreeNode(98693);
//        root.right.right = new TreeNode(-89388);
//        root.right.right.right=new TreeNode(-32127);
//        new Solution().maxLevelSum(root);
//    }
//
//    static class Solution {
//        public int maxLevelSum(TreeNode root) {
//            List<Integer> list = new ArrayList<>();
//            LinkedList<TreeNode> linkedList = new LinkedList<>();
//            linkedList.add(root);
//            while (!linkedList.isEmpty()) {
//                int sum = 0;
//                int size=linkedList.size();
//                for (int i = 0; i < size; i++) {
//                    TreeNode node = linkedList.pop();
//                    if (node.left != null)
//                        linkedList.add(node.left);
//                    if (node.right != null)
//                        linkedList.add(node.right);
//                    sum += node.val;
//                }
//                list.add(sum);
//            }
//            int position = -1;
//            int max = 0;
//            for (int i = 0; i < list.size(); i++) {
//                if (position == -1 || list.get(i) > max) {
//                    position = i + 1;
//                    max = list.get(i);
//                }
//            }
//            return position;
//        }
//    }

    //    static class Solution {
//        public int countCharacters(String[] words, String chars) {
//            int result = 0;
//            int[] cache = new int[26];
//            for (char c : chars.toCharArray()) {
//                cache[c - 'a']++;
//            }
//            for (String word : words) {
//                result += word.length();
//                int[] wordCache = Arrays.copyOf(cache, cache.length);
//                for (char c : word.toCharArray()) {
//                    if (--wordCache[c - 'a'] < 0) {
//                        result -= word.length();
//                        break;
//                    }
//                }
//            }
//            return result;
//        }
//    }


    public static void main(String[] args) {
        new Solution().lastSubstring("abab");
    }

    static class Solution {
        public String lastSubstring(String s) {
            List<Integer> list = new ArrayList<>();
            char maxC = 'a';
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == maxC) {
                    list.add(i);
                } else if (cs[i] > maxC) {
                    maxC = cs[i];
                    list.clear();
                    list.add(i);
                }
            }
            int result = -1;
            int i = 1;
            for (; ; ) {
                Iterator<Integer> it = list.iterator();
                List<Integer> newList = new ArrayList<>();
                char a = 'a';
                while (it.hasNext()) {
                    Integer p = it.next();
                    if (list.size() == 1) {
                        result = p;
                        break;
                    }
                    if (p + i == s.length()) {
                        continue;
                    }
                    if (cs[p + i] == a) {
                        newList.add(p);
                    } else if (cs[p + i] > a) {
                        a = cs[p + i];
                        newList.clear();
                        newList.add(p);
                    }
                }
                if (result >= 0) {
                    break;
                }
                i++;
                list = new ArrayList<>(newList);
            }
            return s.substring(result);
        }
    }

}
