package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0076_Minimum_Window_Substring {


    public static void main(String[] args) {
        new Solution().minWindow("acbbaca", "aba");
    }

    static class Solution {
        public String minWindow(String s, String t) {
            LinkedHashMap<Character, Queue<Integer>> map = new LinkedHashMap<>();
            char[] ts = t.toCharArray();
            for (char c : ts) {
                Queue<Integer> list = map.get(c);
                if (list == null) list = new LinkedList<>();
                list.offer(-1);
                map.put(c, list);
            }
            int size = t.length();
            String result = "";
            char[] cs = s.toCharArray();
            char minC = ' ';
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];
                Queue<Integer> value = map.remove(c);
                if (value == null)
                    continue;
                if (value.poll() == -1) {
                    size--;
                }
                value.offer(i);
                map.put(c, value);
                if (size == 0 && (minC == ' ' || minC == c)) {
                    int minP = 0, maxP = i;
                    for (Map.Entry<Character, Queue<Integer>> entry :
                            map.entrySet()) {
                        minC = entry.getKey();
                        minP = entry.getValue().peek();
                        if (value.peek()<minP) {
                            minP=value.peek();
                            minC=c;
                        }
                        break;
                    }
                    if (result.isEmpty() || result.length() > maxP - minP + 1) {
                        result = s.substring(minP, maxP + 1);
                    }
                }
            }
            return result;
        }
    }
}
