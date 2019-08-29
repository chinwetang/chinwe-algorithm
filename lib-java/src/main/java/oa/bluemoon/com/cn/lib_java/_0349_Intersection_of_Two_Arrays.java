package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0349_Intersection_of_Two_Arrays {

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>(nums2.length);
            for (int i : nums2) {
                set.add(i);
            }
            Set<Integer> list = new HashSet<>();
            for (int i : nums1) {
                if (set.contains(i)) {
                    list.add(i);
                }
            }
            int[] result = new int[list.size()];
            int i = 0;
            for (Integer integer : list) {
                result[i++] = integer;
            }
            return result;
        }
    }


    static class Solution2 {

        public static void main(String[] args) {
            intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        }

        public static int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int p1 = 0, p2 = 0, maxSize = 0;
            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] == nums2[p2]) {
                    nums2[maxSize++] = nums2[p2];
                }
                int temp1=p1,temp2=p2;
                if (nums1[temp1] <= nums2[temp2])
                    while (++p1 < nums1.length && nums1[p1] == nums1[p1 - 1]) ;
                if (nums1[temp1] >= nums2[temp2])
                    while (++p2 < nums2.length && nums2[p2] == nums2[p2 - 1]) ;
            }
            return Arrays.copyOf(nums2, maxSize);
        }
    }
}
