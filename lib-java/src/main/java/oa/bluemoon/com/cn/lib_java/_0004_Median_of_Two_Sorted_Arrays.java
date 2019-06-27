package oa.bluemoon.com.cn.lib_java;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class _0004_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1 = 0, start2 = 0, end1 = nums1.length - 1, end2 = nums2.length - 1;
        while (end1 > start1 && end2 > start2) {
            int median1=(start1+end1)/2,median2=(start2+end2)/2;
            if(nums1[median1]==nums2[median2]){
                return nums1[median1];
            }else if(nums1[median1]>nums2[median2]){
                end1=median1;start2=median2+1;
            }else{
                start1=median1+1;end2=median2;
            }
        }
         return (nums1[start1]+nums2[start2])/2;
    }
}
