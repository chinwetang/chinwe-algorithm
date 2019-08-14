package oa.bluemoon.com.cn.lib_java.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 8, 4, 0, 3, 78, 21, 65, 32, 84, 2, 4};
        int[] result=new MergeSort().sort(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
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

}
