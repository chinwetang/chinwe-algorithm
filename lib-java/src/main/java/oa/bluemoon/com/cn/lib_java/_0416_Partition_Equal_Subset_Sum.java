package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0416_Partition_Equal_Subset_Sum {

    /**
     * 超出时间限制
     */
    static class Solution {
        int[][] cache;

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum % 2 == 1)
                return false;
            cache = new int[nums.length][sum / 2 + 1];
            return canPartition(sum / 2, nums, 0, 0);
        }

        public boolean canPartition(int max, int[] nums, int position, int num) {
            if (num > max || position >= nums.length)
                return false;
            if (num == max)
                return true;
            if (cache[position][num] == 0) {
                boolean result = canPartition(max, nums, position + 1, num + nums[position])
                        || canPartition(max, nums, position + 1, num);
                cache[position][num] = result ? 1 : -1;
            }
            return cache[position][num] == 1;
        }
    }


    static class Solution2 {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int[] counts = new int[101];
            for (int i : nums) {
                counts[i]++;
                sum += i;
            }
            if (sum % 2 == 1)
                return false;
            int left = 0, right = 0;

        }

    }


}
