package oa.bluemoon.com.cn.lib_java.sort;

/**
 * 手写插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{};
        new InsertionSort().sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    //这是一个从小到大的插入排序算法
    public void sort(int[] nums) {
        //从1开始，前面留一位
        for (int i = 1; i < nums.length; i++) {
            //缓存出来，待找到位置插进去
            int cache = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > cache) {
                    //不满足条件的右移一位
                    nums[j + 1] = nums[j];
                } else {
                    //找到插入的位置了，就是此时对应的j+1
                    break;
                }
            }
            //插进去
            nums[j + 1] = cache;
        }
    }

}
