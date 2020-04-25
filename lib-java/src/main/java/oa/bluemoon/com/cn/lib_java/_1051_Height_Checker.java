package oa.bluemoon.com.cn.lib_java;

/**
 *学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *
 * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 *
 * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 *
 *  
 *
 * 示例：
 *
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 当前数组：[1,1,4,2,1,3]
 * 目标数组：[1,1,1,2,3,4]
 * 在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
 * 在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
 * 在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。
 * 示例 2：
 *
 * 输入：heights = [5,1,2,3,4]
 * 输出：5
 * 示例 3：
 *
 * 输入：heights = [1,2,3,4,5]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/height-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1051_Height_Checker {

    class Solution {
        public int heightChecker(int[] heights) {
            int[] nums=new int[heights.length];
            for (int i = 0; i < heights.length; i++) {
                nums[i] = heights[i];
            }
            sort(heights,0,heights.length-1);
            int res=0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=heights[i])
                    res++;
            }
            return res;
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
}
