package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.misc.LRUCache;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0402_Remove_K_Digits {

    class Solution {


        HashMap<String, String> map = new HashMap<>();


        public String removeKdigits(String num, int k) {
            if (k == 0) return num;

            String key = num + "-" + k;

            String value = map.get(key);
            if (value != null) return value;
            String min = null;
            for (int i = 0; i < num.length(); i++) {
                String newNum = rid(num, i);
                if (min == null) {
                    min = newNum;
                } else if (min.compareTo(newNum) >= 0) {
                    min = newNum;
                }
            }
            map.put(key, min);
            return min;
        }

        public String rid(String num, int pos) {
            StringBuffer newNumBuf = new StringBuffer();
            for (int i = 0; i < num.length(); i++) {
                if (i != pos)
                    newNumBuf.append(num.charAt(i));
            }
            return newNumBuf.toString();
        }


        public String trim(String num) {
            if (num.length() == 0 || "0".equals(num)) {
                return "0";
            } else if (num.startsWith("0")) {
                return trim(num.substring(1));
            } else {
                return num;
            }

        }
    }
}
