package oa.bluemoon.com.cn.lib_java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0003_Longest_Substring_Without_Repeating_Characters {


    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("我和和你它和你你");
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0, start = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                Integer last = map.get(c);
                if (last != null && last >= start) {
                    max = Math.max(max, i - start);
                    start = last + 1;
                    if (max >= s.length() - start) {
                        return max;
                    }
                }
                map.put(c, i);
            }
            max = Math.max(s.length() - start, max);
            return max;
        }
    }

    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0)
                return 0;
            int[] a = new int[256];
            int i = 0;
            int max = 1;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                i = Math.max(a[c], i);
                max = Math.max(max, j - i + 1);
                a[c] = j + 1;
            }
            return max;
        }
    }
}
