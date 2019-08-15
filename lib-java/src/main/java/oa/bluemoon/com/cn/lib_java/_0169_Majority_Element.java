package oa.bluemoon.com.cn.lib_java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0169_Majority_Element {

    static class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) || i <= nums.length / 2) {
                    Integer sum = map.get(nums[i]);
                    if (sum == null) sum = 0;
                    sum++;
                    if (sum > nums.length / 2)
                        return nums[i];
                    map.put(nums[i], sum);
                }
                if (i > nums.length / 2) {
                    Iterator<Integer> it = map.keySet().iterator();
                    while (it.hasNext()) {
                        if (map.get(it.next()) + nums.length - i - 1 <= nums.length / 2) {
                            it.remove();
                        }
                    }
                    if (map.size() == 1)
                        for (Integer integer : map.keySet()) {
                            return integer;
                        }
                }
            }
            return 0;
        }
    }

    static class Solution2 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i <= nums.length / 2; i++) {
                Integer sum = map.get(nums[i]);
                if (sum == null) sum = 0;
                sum++;
                if (sum > nums.length / 2)
                    return nums[i];
                map.put(nums[i], sum);
            }
            for (int i = nums.length / 2 + 1; i < nums.length; i++) {
                Iterator<Integer> it = map.keySet().iterator();
                while (it.hasNext()) {
                    Integer key = it.next();
                    Integer value = map.get(key);
                    Integer c = key == nums[i] ? 1 : 0;
                    if (value + c > nums.length / 2) {
                        return key;
                    } else if (value + nums.length - i <= nums.length / 2) {
                        it.remove();
                    } else {
                        map.put(key, value + c);
                    }
                }
                if (map.size() == 1)
                    for (Integer integer : map.keySet()) {
                        return integer;
                    }
            }
            return 0;
        }
    }


    static class Solution3 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

}
