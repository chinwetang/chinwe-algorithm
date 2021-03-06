package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0060_Permutation_Sequence {

    public static void main(String[] args) {
        new Solution().getPermutation(3, 6);
    }

    static class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> list = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            StringBuilder builder = new StringBuilder();
            while (n > 0 && k > 0) {
                int factorial = factorial(--n);
                int i = (int) Math.ceil(k * 1f / factorial);
                builder.append(list.remove(i - 1));
                k = k % factorial;
            }
            if (k == 0)
                for (int i = list.size() - 1; i >= 0; i--) {
                    builder.append(list.get(i));
                }
            return builder.toString();
        }

        Map<Integer, Integer> map = new HashMap<>();

        public int factorial(int k) {
            Integer result = map.get(k);
            if (result == null) {
                result = 1;
                while (k > 0) {
                    result *= k--;
                }
                map.put(k, result);
            }
            return result;
        }
    }
}
