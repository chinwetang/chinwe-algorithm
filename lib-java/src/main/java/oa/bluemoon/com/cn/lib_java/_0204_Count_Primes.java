package oa.bluemoon.com.cn.lib_java;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class _0204_Count_Primes {

    static class Solution {
        public int countPrimes(int n) {
            int count = 0;
            int[] signs = new int[n / 32 + 1];
            for (int i = 2; i < n; i++) {
                if ((signs[i / 32] | (1 << (i & 31))) != signs[i / 32]) {
                    count++;
                    for (int j = i + i; j < n; j += i) {
                        //登记该数字
                        signs[j / 32] |= 1 << (j & 31);
                    }
                }
            }
            return count;
        }
    }
}
