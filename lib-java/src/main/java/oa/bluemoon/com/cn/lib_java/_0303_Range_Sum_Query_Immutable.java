package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class _0303_Range_Sum_Query_Immutable {
    public static class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int result = 0;
            for (int k = i; k < j + 1; k++) {
                result += nums[k];
            }
            return result;
        }
    }

    public static class NumArray2 {
        private int[] sums;

        public NumArray2(int[] nums) {
            sums = new int[nums.length];
            if (nums.length == 0)
                return;
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0)
                return sums[j];
            else
                return sums[j] - sums[i - 1];
        }
    }
}
