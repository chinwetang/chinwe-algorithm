package oa.bluemoon.com.cn.lib_java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0242_Valid_Anagram {

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null)
                return false;
            if (s.length() != t.length())
                return false;
            int[] nums = new int[26];
            for (char c : s.toCharArray()) {
                nums[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                if (--nums[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
