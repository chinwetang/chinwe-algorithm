package oa.bluemoon.com.cn.lib_java;

/**
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，以下数列为等差数列:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 * <p>
 * 1, 1, 2, 5, 7
 *  
 * <p>
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * <p>
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * <p>
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * <p>
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0413_Arithmetic_Slices {

    class Solution {

        public int numberOfArithmeticSlices(int[] A) {
            if (A.length < 3) return 0;
            int start = 0, end = 1, res = 0;
            while (end < A.length) {
                if (end < A.length - 1 && A[end - 1] - A[end] == A[end] - A[end + 1]) {
                    end++;
                } else {
                    if (end - start > 1) {
                        res += (end - start + 1 - 2) * ((end - start + 1 - 2) + 1) / 2;
                    }
                    start = end;
                    end++;
                }
            }
            return res;
        }

    }
}
