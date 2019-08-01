package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0005_Longest_Palindromic_Substring {

    public static void main(String[] args) {

    }

    static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0)
                return "";
            List<Character> maxChildList = new ArrayList<>();
            maxChildList.add(s.charAt(0));
            for (int i = 0; i < s.length(); i++) {
                int left = i, right = i;
                List<Character> list = new ArrayList<>();
                list.add(s.charAt(i));
                while (++right < s.length()) {
                    Character c = s.charAt(right);
                    if (c != list.get(0)) {
                        --right;
                        break;
                    }
                    list.add(c);
                    i++;
                }
                while ((--left >= 0 & ++right < s.length())) {
                    Character l = s.charAt(left);
                    Character r = s.charAt(right);
                    if (l != r)
                        break;
                    list.add(0, l);
                    list.add(r);
                }
                if (list.size() > maxChildList.size()) {
                    maxChildList.clear();
                    maxChildList.addAll(list);
                }
            }
            StringBuffer buffer = new StringBuffer();
            for (Character character : maxChildList) {
                buffer.append(character);
            }
            return buffer.toString();
        }
    }

}
