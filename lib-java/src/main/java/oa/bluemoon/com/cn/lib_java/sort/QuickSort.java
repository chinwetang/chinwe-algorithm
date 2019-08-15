package oa.bluemoon.com.cn.lib_java.sort;

import java.util.concurrent.Executors;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3423,657,3,768,34,757,45, 6, 45, 1, 5,34,34,34,34,34,34,34,34, 3, 8, 4, 46, 3, 78, 21, 65,1,1,1,1,1,1, 32, 84, 2, 4};
        new QuickSort().sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public void sort(int[] nums, int star, int end) {
        //递归终止条件,小于五个元素用插入更佳
        if (end - star < 5) {
            insertionsort(nums, star, end);
            return;
        }
        //三数取中
        int middle = (star + end) / 2;
        int v = (nums[star] + nums[end] + nums[middle]) - threeSumFromMaxMin(nums[star],
                nums[end], nums[middle]);

        //三路
        int vStart = star - 1;
        int left = star, right = end;
        while (left <= right) {
            if (nums[left] < v) {
                swap(nums, ++vStart, left++);
            } else if (nums[left] > v) {
                swap(nums, left, right--);
            } else {
                left++;
            }
        }
        sort(nums,star,vStart);
        sort(nums,right+1,end);
    }
    //交换位置
    public void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
    //这是一个从小到大的插入排序算法
    public void insertionsort(int[] nums, int start, int end) {
        //前面留一位
        for (int i = start + 1; i <= end; i++) {
            //缓存出来，待找到位置插进去
            int cache = nums[i];
            int j = i - 1;
            for (; j >= start; j--) {
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
    //取三数最大
    public int threeMax(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
    //取三数最小
    public int threeMin(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }
    //取三数最小和最大之和
    public int threeSumFromMaxMin(int num1, int num2, int num3) {
        return threeMax(num1, num2, num3) + threeMin(num1, num2, num3);
    }
}
