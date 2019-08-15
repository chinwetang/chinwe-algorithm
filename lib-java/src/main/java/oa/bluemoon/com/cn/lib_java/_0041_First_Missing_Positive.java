package oa.bluemoon.com.cn.lib_java;

public class _0041_First_Missing_Positive {
    static class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                while (temp > 0 && temp <= nums.length && nums[temp - 1] != temp) {
                    int k = nums[temp - 1];
                    nums[temp - 1] = temp;
                    temp = k;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 1 || nums[i] > nums.length || nums[i] != i + 1)
                    return i + 1;
            }
            return 0;
        }
    }
}
