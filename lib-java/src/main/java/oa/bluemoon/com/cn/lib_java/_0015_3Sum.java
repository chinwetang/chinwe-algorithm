package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0015_3Sum {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            //先排序
            Arrays.sort(nums);
            //选三数最左那个位置i
            for (int i = 0; i < nums.length - 2; i++) {
                //连续重复只取第一次
                if (i == 0 || nums[i] != nums[i - 1]) {
                    //取两端的最大和最小值，三数之和转换成两数之和
                    int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                    while (lo < hi) {
                        if (nums[lo] + nums[hi] == sum) {
                            lists.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                            //满足条件的只取一次
                            while (lo < hi && nums[lo] == nums[++lo]) ;
                            while (lo < hi && nums[hi] == nums[--hi]) ;
                        } else if (nums[lo] + nums[hi] < sum) {
                            //nums[hi]已经是最大了，nums[lo] + nums[hi]还是偏小，只能增大nums[lo]，反之亦然
                            lo++;
                        } else hi--;
                    }
                }
            }
            //上面已经过滤了重复的情况，所以直接返回结果就是
            return lists;
        }
    }
}
