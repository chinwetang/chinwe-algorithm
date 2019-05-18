package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 说明:
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 */
public class _304_Range_Sum_Query_2D_Immutable {

    public static void main(String[] args) {
        System.out.print(new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1,
                7}, {1, 0, 3, 0, 5}}).sumRegion(2, 1, 4, 3));
    }

    static class NumMatrix {

        int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            int row =  matrix.length;
            int col =matrix[0].length;
            sums = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i * j == 0) {
                        if (i == 0 && j == 0) {
                            sums[i][j] = matrix[i][j];
                        } else {
                            if (i == 0) {
                                sums[i][j] = sums[i][j - 1] + matrix[i][j];
                            }
                            if (j == 0) {
                                sums[i][j] = sums[i - 1][j] + matrix[i][j];
                            }
                        }

                    } else {
                        sums[i][j] = sums[i][j - 1] + sums[i - 1][j] - sums[i - 1][j - 1]+matrix[i][j];
                    }
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (col1 * row1 == 0) {
                if (col1 == 0 && row1 == 0) {
                    return sums[row2][col2];
                } else {
                    if (col1 == 0) {
                        return sums[row2][col2] - sums[row1 - 1][col2];
                    } else {
                        return sums[row2][col2] - sums[row2][col1 - 1];
                    }
                }

            } else {
                return sums[row2][col2] - sums[row1 - 1][col2] - sums[row2][col1 - 1] + sums[row1 - 1][col1
                        - 1];
            }
        }
    }
}
