package oa.bluemoon.com.cn.lib_java;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0085_Maximal_Rectangle {

    static class Solution {
//        public int maximalRectangle(char[][] matrix) {
//            int max = 0;
//            int row = matrix.length;
//            int column = matrix[0].length;
//            for (int i = 0; i < row; i++) {
//                for (int j = 0; j < column; j++) {
//                    if (matrix[i][j] == '0')
//                        continue;
//                    //向下、向右寻找最大可能的矩形（不包括左边和上边的情况）
//                    int nMax = 1;
//                    int nI = 1, nJ = 1;
//                    while (i + nI < row && matrix[i + nI][j] == '1') {
//
//                    }
//
//
//                    // 再跟左边和上边做比较，取最大值
//                }
//            }
//        }
    }
}
