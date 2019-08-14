package oa.bluemoon.com.cn.lib_java;

/**
 * 如果正整数可以被 A 或 B 整除，那么它是神奇的。
 * <p>
 * 返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 1, A = 2, B = 3
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：N = 4, A = 2, B = 3
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：N = 5, A = 2, B = 4
 * 输出：10
 * 示例 4：
 * <p>
 * 输入：N = 3, A = 6, B = 4
 * 输出：8
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * 2 <= A <= 40000
 * 2 <= B <= 40000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-magical-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0878_Nth_Magical_Number {

    static class Solution {
        public int nthMagicalNumber(int N, int A, int B) {
            int stage = 0;
            int little = Math.min(A, B), big = Math.max(A, B);
            for (int time = 1; ; time++) {

            }
        }
    }
}
