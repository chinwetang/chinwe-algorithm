package oa.bluemoon.com.cn.lib_java.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{};
        new SelectionSort().sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    //这是一个从小到大的选择排序算法
    public void sort(int[] nums) {
        //最右边那位不取
        for (int i = 0; i < nums.length - 1; i++) {
            //暂定最小的是当前值
            int minP = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minP]) {
                    //找到更小的
                    minP = j;
                }
            }
            //将最小的和当前值互换位置
            int temp = nums[i];
            nums[i] = nums[minP];
            nums[minP] = temp;
        }
    }
}
