package oa.bluemoon.com.cn.lib_java;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 * <p>
 * 输入：[3,6,2,3]
 * 输出：8
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0976_Largest_Perimeter_Triangle {

    static class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for (int i = A.length - 1; i >= 2; i--) {
                if (A[i] < A[i - 1] + A[i - 2])
                    return A[i] + A[i - 1] + A[i - 2];
            }
            return 0;
        }
    }


    static class Solution2 {

        public static void main(String[] args) {
            new Solution2().largestPerimeter(new int[]{2, 1, 2});
        }

        //冒泡和选择每次可以把最大选出来，选出来三个我们就可以开始算了，不用管后面得
        //这里我们使用选择排序，省去每次交换得消耗
        public int largestPerimeter(int[] A) {
            for (int i = 0; i < A.length; i++) {
                int minP = i;
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] > A[minP]) {
                        minP = j;
                    }
                }
                int temp = A[i];
                A[i] = A[minP];
                A[minP] = temp;
                if (i >= 2 && A[i - 2] < A[i - 1] + A[i])
                    return A[i] + A[i - 1] + A[i - 2];
            }
            return 0;
        }
    }
}
