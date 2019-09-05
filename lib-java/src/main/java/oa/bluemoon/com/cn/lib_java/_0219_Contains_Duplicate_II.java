package oa.bluemoon.com.cn.lib_java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0219_Contains_Duplicate_II {

    static class Solution {

        public static void main(String[] args) {
            new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        }

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>(nums.length * 2);
            for (int i = 0; i < nums.length; i++) {
                Integer value = map.get(nums[i]);
                if (value != null && i - value <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }
}
