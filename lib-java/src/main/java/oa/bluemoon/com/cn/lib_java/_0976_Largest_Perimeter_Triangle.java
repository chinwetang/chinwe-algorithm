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

    /**
     * 方案一：先排序后筛选 [LeetCode：22ms]
     */
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

    /**
     * 方案二：选择排序，提前筛选 [LeetCode:14ms]
     */
    static class Solution2 {
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

    /**
     * 方案三：大顶堆，提前筛选 [LeetCode:8ms]
     */
    static class Solution3 {
        /**
         * 大顶堆
         *
         * @param A
         */
        public int largestPerimeter(int[] A) {
            buildHeap(A);
            for (int i = A.length - 1; i >= 0; i--) {
                swap(A, 0, i);
                adjust(A, i, 0);
                if (i < A.length - 2 && A[i + 2] < A[i + 1] + A[i]) {
                    return A[i + 2] + A[i + 1] + A[i];
                }
            }
            return 0;
        }

        /**
         * 调整
         *
         * @param nums
         * @param length
         * @param x
         */
        public void adjust(int[] nums, int length, int x) {
            while (x <= length / 2 - 1) {
                int left = nums[2 * x + 1];
                int right = left - 1;
                if (2 * x + 2 < length) {
                    right = nums[2 * x + 2];
                }
                int max = Math.max(left, right);
                if (nums[x] >= max)
                    break;
                if (max == left) {
                    int temp = nums[x];
                    nums[x] = left;
                    nums[2 * x + 1] = temp;
                    x = 2 * x + 1;
                } else {
                    int temp = nums[x];
                    nums[x] = right;
                    nums[2 * x + 2] = temp;
                    x = 2 * x + 2;
                }
            }
        }


        /**
         * 交换两个数
         *
         * @param nums
         * @param i
         * @param j
         */
        public void swap(int[] nums, int i, int j) {
            if (i == j)
                return;
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }

        /**
         * 建堆
         *
         * @param nums
         */
        public void buildHeap(int[] nums) {
            int length = nums.length;
            for (int i = length / 2 - 1; i >= 0; i--) {
                adjust(nums, nums.length, i);
            }
        }
    }
}
