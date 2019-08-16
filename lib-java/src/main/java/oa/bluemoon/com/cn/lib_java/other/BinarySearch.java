package oa.bluemoon.com.cn.lib_java.other;

import oa.bluemoon.com.cn.lib_java.sort.MergeSort;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{45, 34, 23, 12, 2, 1, -1, -123};
        System.out.print(new BinarySearch().find(nums, 45) + ",");
    }

    public int find(int[] data, int target) {
        if (data == null)
            return -1;
        if (data.length == 1)
            return data[0] == target ? 0 : -1;
        //第一步，先确定正序还是倒序
        boolean positiveSequence = data[data.length - 1] > data[0];
        //查找区间
        int[] scope = new int[]{0, data.length - 1};
        while (scope[0] < scope[1]) {
            int middle = (scope[0] + scope[1]) / 2;
            if (data[middle] == target) {
                return middle;
            } else if (data[middle] > target ^ positiveSequence) {
                scope[0] = middle + 1;
            } else {
                scope[1] = middle - 1;
            }
        }
        //最后校验是否存在这个数
        return data[scope[0]] == target ? scope[0] : -1;
    }

}
