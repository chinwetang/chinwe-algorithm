package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class _035_Search_Insert_Position {

    public static void main(String[] args) {
        System.out.print(new _035_Search_Insert_Position().searchInsert(new int[]{1, 3, 5, 6}, 2));
    }


    public int searchInsert(int[] nums, int target) {
        int start = 0,end = nums.length-1;
        while (start<=end) {
            int position = (end + start) / 2;
            if (nums[position] > target) {
                end = position-1;
            } else if (nums[position] < target) {
                start = position+1;
            } else {
                return position;
            }
        }
        return start;
    }

}
