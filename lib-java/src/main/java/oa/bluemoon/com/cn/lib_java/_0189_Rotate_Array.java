package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0189_Rotate_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        new Solution2().rotate(nums, 2);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            if (k == 0)
                return;
            Stack<Integer> stack = new Stack<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i >= nums.length - k) {
                    stack.push(nums[i]);
                } else {
                    nums[i + k] = nums[i];
                }
            }
            for (int i = 0; i < k; i++) {
                nums[i] = stack.pop();
            }
        }
    }

    static class Solution2 {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            if (length == 0)
                return;
            k = k % length;
            if (k == 0)
                return;
            if (k > length / 2) {
                k = k-length;
            }
            if (length % k == 0) {
                for (int j = 0; j < Math.abs(k); j++) {
                    int e = nums[j];
                    for (int i = 0; i < Math.abs(length / k); i++) {
                        int nextP = (length + j + (i + 1) * k) % length;
                        int p = nums[nextP];
                        nums[nextP] = e;
                        e = p;
                    }
                }
            } else {
                int e = nums[0];
                int nextP = 0;
                for (int i = 0; i < length; i++) {
                    nextP = (length + nextP + k) % length;
                    int p = nums[nextP];
                    nums[nextP] = e;
                    e = p;
                }
            }
        }
    }

    static class Solution3 {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            if (length == 0)
                return;
            k = k % length;
            if (k == 0)
                return;
            if (k > length / 2) {
                k = k-length;
            }
            if (length % k == 0) {
                for (int j = 0; j < Math.abs(k); j++) {
                    int e = nums[j];
                    for (int i = 0; i < Math.abs(length / k); i++) {
                        int nextP = (length + j + (i + 1) * k) % length;
                        int p = nums[nextP];
                        nums[nextP] = e;
                        e = p;
                    }
                }
            } else {
                int e = nums[0];
                int nextP = 0;
                for (int i = 0; i < length; i++) {
                    nextP = (length + nextP + k) % length;
                    int p = nums[nextP];
                    nums[nextP] = e;
                    e = p;
                }
            }
        }
    }
}
