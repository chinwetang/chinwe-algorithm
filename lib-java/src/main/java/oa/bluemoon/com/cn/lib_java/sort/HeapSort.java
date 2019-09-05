package oa.bluemoon.com.cn.lib_java.sort;

/**
 * 堆排序
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 1, 9, 5, 3, 4, 6, 7, 8, 9, 1, 5, 4, 6, 4};
        new HeapSort().sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }


    /**
     * 大顶堆
     *
     * @param nums
     */
    public void sort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjust(nums, i,0);
        }

    }

    /**
     * 调整
     * @param nums
     * @param length
     * @param x
     */
    public void adjust(int[] nums, int length, int x) {
        while (x <= length / 2 - 1) {
            int left = nums[2 * x + 1];
            int right = left - 1;
            if (2 * x + 2 < length) {
                right = nums[2 * x + 2];
            }
            int max = Math.max(left, right);
            if (nums[x] >= max)
                break;
            if (max == left) {
                int temp = nums[x];
                nums[x] = left;
                nums[2 * x + 1] = temp;
                x = 2 * x + 1;
            } else {
                int temp = nums[x];
                nums[x] = right;
                nums[2 * x + 2] = temp;
                x = 2 * x + 2;
            }
        }
    }


    /**
     * 交换两个数
     *
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    /**
     * 建堆
     *
     * @param nums
     */
    public void buildHeap(int[] nums) {
        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(nums, nums.length, i);
        }
    }

}
