package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释: https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/diagonal_traverse.png
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0498_Diagonal_Traverse {

    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[0];
            List<Integer> list = new ArrayList<>();
            boolean revel = false;
            for (int i = 0; i < matrix.length + matrix[0].length - 1; i++) {
                int h, v;
                if (i >= matrix.length) {
                    h = matrix.length - 1;
                    v = i - h;
                } else {
                    h = i;
                    v = 0;
                }
                int l = list.size();
                for (; h >= 0 && v < matrix[0].length; h--, v++) {
                    if (revel) {
                        list.add(l, matrix[h][v]);
                    } else {
                        list.add(matrix[h][v]);
                    }
                }
                revel = !revel;
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }


    class Solution2 {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[0];
            int[] res = new int[matrix.length * matrix[0].length];
            int cursor = 0;
            for (int i = 0; i < matrix.length + matrix[0].length - 1; i++) {
                int h, v;
                if (i >= matrix.length) {
                    h = matrix.length - 1;
                    v = i - h;
                } else {
                    h = i;
                    v = 0;
                }
                int start = cursor;
                int end = cursor + Math.min(h + 1, matrix[0].length - v);
                cursor = end;
                boolean pos = i % 2 == 0;
                for (; h >= 0 && v < matrix[0].length; h--, v++) {
                    if (pos) {
                        res[start++] = matrix[h][v];
                    } else {
                        res[--end] = matrix[h][v];
                    }
                }
            }
            return res;
        }
    }
}
