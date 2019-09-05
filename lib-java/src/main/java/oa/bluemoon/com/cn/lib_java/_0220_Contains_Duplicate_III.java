package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0220_Contains_Duplicate_III {

    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    list.remove(Integer.valueOf(nums[i - k - 1]));
                }
                int insert = 0;
                for (; insert < list.size(); insert++) {
                    if (Math.abs((long) nums[i] - list.get(insert)) <= t) {
                        return true;
                    }
                    if (nums[i] < list.get(insert)) {
                        break;
                    }
                }
                list.add(insert, nums[i]);
            }
            return false;
        }
    }
}
