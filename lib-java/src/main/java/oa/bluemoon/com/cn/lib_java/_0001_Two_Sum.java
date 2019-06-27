package oa.bluemoon.com.cn.lib_java;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class _0001_Two_Sum {
    public static void main(String[] args) {
        int[] result = new _0001_Two_Sum().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.print(result[0] + "" + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer p = map.get(target - nums[i]);
            if (p != null) {
                return new int[]{p, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
