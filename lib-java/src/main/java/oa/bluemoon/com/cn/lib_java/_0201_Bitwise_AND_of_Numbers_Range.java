package oa.bluemoon.com.cn.lib_java;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1: 
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: [0,1]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0201_Bitwise_AND_of_Numbers_Range {

    public static void main(String[] args) {
        System.out.println(""+new Solution().rangeBitwiseAnd(5,7));
    }

    static class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            if (m == n) return m;
            int i = 0;
            for (; Math.pow(2, i) < (n - m + (m) % 2); i++) ;
            return n & (~((int)Math.pow(2,i)-1));
        }
    }
}
