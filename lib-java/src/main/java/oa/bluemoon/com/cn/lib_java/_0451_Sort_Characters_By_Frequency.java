package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0451_Sort_Characters_By_Frequency {

    public static void main(String[] args) {
        new Solution().frequencySort("raaeaedere");
    }

    static class Solution {
        public String frequencySort(String s) {
            HashMap<Character, StringBuffer> map = new HashMap<>();
            for (Character c : s.toCharArray()) {
                StringBuffer v = map.get(c);
                if (v == null) {
                    v = new StringBuffer();
                }
                map.put(c, v.append(c));
            }
            PriorityQueue<Pair<Character, StringBuffer>> maxHeap =
                    new PriorityQueue<>((o1, o2) -> o2.getValue().length() - o1.getValue().length());
            for (Map.Entry<Character, StringBuffer> entry : map.entrySet()) {
                maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
            }
            StringBuffer buffer = new StringBuffer();
            while (!maxHeap.isEmpty()) {
                Pair<Character, StringBuffer> pair = maxHeap.poll();
                buffer.append(pair.getValue());
            }
            return buffer.toString();
        }
    }


    static class Solution2 {
        public String frequencySort(String s) {
            HashMap<Character, StringBuffer> map = new HashMap<>();
            for (Character c : s.toCharArray()) {
                StringBuffer v = map.get(c);
                if (v == null) {
                    v = new StringBuffer();
                }
                map.put(c, v.append(c));
            }
            StringBuffer[] buffers = new StringBuffer[s.length() + 1];
            for (Map.Entry<Character, StringBuffer> entry : map.entrySet()) {
                if (buffers[entry.getValue().length()] == null)
                    buffers[entry.getValue().length()] = new StringBuffer();
                buffers[entry.getValue().length()].append(entry.getValue());
            }
            StringBuffer res = new StringBuffer();
            for (int i = buffers.length - 1; i >= 0; i--) {
                if (buffers[i] != null) res.append(buffers[i]);
            }
            return res.toString();
        }
    }

    static class Solution3 {
        public String frequencySort(String s) {
            HashMap<Character, StringBuffer> map = new HashMap<>();
            for (Character c : s.toCharArray()) {
                StringBuffer v = map.get(c);
                if (v == null) {
                    v = new StringBuffer();
                }
                map.put(c, v.append(c));
            }
            Map.Entry<Character, StringBuffer>[] entries = new Map.Entry[map.size()];
            map.entrySet().toArray(entries);
            Arrays.sort(entries, (o1, o2) -> o2.getValue().length() - o1.getValue().length());
            StringBuffer res = new StringBuffer();
            for (Map.Entry<Character, StringBuffer> entry : entries) {
                res.append(entry.getValue());
            }
            return res.toString();
        }
    }

    static class Solution4 {
        public String frequencySort(String s) {
            HashMap<Character, StringBuffer> map = new HashMap<>();
            for (Character c : s.toCharArray()) {
                StringBuffer v = map.get(c);
                if (v == null) {
                    v = new StringBuffer();
                }
                map.put(c, v.append(c));
            }
            Map.Entry<Character, StringBuffer>[] entries = new Map.Entry[map.size()];
            map.entrySet().toArray(entries);
            Arrays.sort(entries, (o1, o2) -> o2.getValue().length() - o1.getValue().length());
            StringBuffer res = new StringBuffer();
            for (Map.Entry<Character, StringBuffer> entry : entries) {
                res.append(entry.getValue());
            }
            return res.toString();
        }
    }
}