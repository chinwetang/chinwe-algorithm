package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
