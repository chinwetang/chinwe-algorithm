package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class _053_Maximum_Subarray {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int maxSum=sums[0];
        for (int i = 1; i < nums.length; i++) {
            if(sums[i-1]>0){
                sums[i]=sums[i-1]+nums[i];
            }else{
                sums[i]=nums[i];
            }
            maxSum=Math.max(maxSum,sums[i]);
        }
        return maxSum;
    }
}
