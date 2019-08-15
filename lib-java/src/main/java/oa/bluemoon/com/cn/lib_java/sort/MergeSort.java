package oa.bluemoon.com.cn.lib_java.sort;

import java.util.LinkedList;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{45, 6, 45, 1, 5, 3, 8, 4, 0, 3, 78, 21, 65, 32, 84, 2, 4};
        new MergeSort().mergeSortBU(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public int[] sort(int[] nums) {
        //给个递归终止条件
        if (nums.length <= 1)
            return nums;
        //拆
        int[] lefts = new int[nums.length / 2];
        int[] rights = new int[nums.length - nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                lefts[i] = nums[i];
            } else {
                rights[i - nums.length / 2] = nums[i];
            }
        }
        int[] resultLefts = sort(lefts);
        int[] resultRights = sort(rights);
        //合
        int[] results = new int[resultLefts.length + resultRights.length];
        int l = 0, r = 0;
        for (int i = 0; i < results.length; i++) {
            if (l == resultLefts.length) {
                results[i] = resultRights[r++];
            } else if (r == resultRights.length) {
                results[i] = resultLefts[l++];
            } else if (resultLefts[l] < resultRights[r]) {
                results[i] = resultLefts[l++];
            } else {
                results[i] = resultRights[r++];
            }
        }
        return results;
    }


    public void mergeSortBU(int[] nums, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                _merge(nums, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }

    }

    private void _merge(int[] nums, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int left = start, right = middle + 1;
        for (int i = start; i <= end; i++) {
            if (left > middle) {
                temp[i - start] = nums[right++];
            } else if (right > end) {
                temp[i - start] = nums[left++];
            } else if (nums[left] < nums[right]) {
                temp[i - start] = nums[left++];
            } else {
                temp[i - start] = nums[right++];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }

}
