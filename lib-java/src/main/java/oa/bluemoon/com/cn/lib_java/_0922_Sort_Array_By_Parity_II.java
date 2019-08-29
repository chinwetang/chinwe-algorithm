package oa.bluemoon.com.cn.lib_java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0922_Sort_Array_By_Parity_II {


    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int i = 0, j = 1;
            for (; i < A.length; i += 2)
                if ((A[i] & 1) == 1)
                    for (; j < A.length; j += 2)
                        if ((A[j] & 1) == 0) {
                            int temp = A[i];
                            A[i] = A[j];
                            A[j] = temp;
                            break;
                        }
            return A;
        }
    }
}
