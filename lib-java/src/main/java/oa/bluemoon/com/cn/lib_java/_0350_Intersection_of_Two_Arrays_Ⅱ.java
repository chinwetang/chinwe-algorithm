package oa.bluemoon.com.cn.lib_java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0350_Intersection_of_Two_Arrays_Ⅱ {



    static class Solution {

        public static void main(String[] args) {
            intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        }

        public static int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int p1 = 0, p2 = 0, maxSize = 0;
            while (p1 < nums1.length && p2 < nums2.length) {
                int temp1=p1,temp2=p2;
                if (nums1[temp1] == nums2[temp2]) {
                    nums2[maxSize++] = nums2[p2];
                    p1++;p2++;
                }else if(nums1[temp1] < nums2[temp2]){
                    while (++p1 < nums1.length && nums1[p1] == nums1[p1 - 1]) ;
                }else{
                    while (++p2 < nums2.length && nums2[p2] == nums2[p2 - 1]) ;
                }
            }
            return Arrays.copyOf(nums2, maxSize);
        }
    }
}
