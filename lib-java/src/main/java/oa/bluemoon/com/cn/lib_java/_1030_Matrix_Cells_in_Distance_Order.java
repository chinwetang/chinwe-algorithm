package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| +
 * |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 * <p>
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1030_Matrix_Cells_in_Distance_Order {

    static class Solution {

        public static void main(String[] args) {
            allCellsDistOrder(1, 2, 0, 0);
        }

        public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            Queue<int[]> result = new LinkedList<>();
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{r0, c0});
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                if (point[0] >= 1) {
                    int[] left = new int[]{point[0] - 1, point[1]};
                    if (!result.contains(left))
                        queue.offer(left);
                }
                if (point[0] + 1 < R) {
                    int[] right = new int[]{point[0] + 1, point[1]};
                    if (!result.contains(right))
                        queue.offer(right);
                }
                if (point[1] >= 1) {
                    int[] top = new int[]{point[0], point[1] - 1};
                    if (!result.contains(top))
                        queue.offer(top);
                }
                if (point[1] + 1 < C) {
                    int[] bottom = new int[]{point[0], point[1] + 1};
                    if (!result.contains(bottom))
                        queue.offer(bottom);
                }
                result.add(point);
            }
            return (int[][]) result.toArray();
        }
    }


    static class Solution2 {

        public static void main(String[] args) {
        }

        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int maxSize = Math.max(R-r0-1,r0)+Math.max(C-c0-1,c0)+1;
            List<List<int[]>> results = new ArrayList<>();
            for (int i = 0; i < maxSize; i++) {
                results.add(new ArrayList<int[]>());
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int mhd = Math.abs(r0 - i) + Math.abs(c0 - j);
                    results.get(mhd).add(new int[]{i, j});
                }
            }
            int[][] result = new int[R * C][];
            int i = 0;
            for (List<int[]> list : results) {
                for (int[] ints : list) {
                    result[i++] = ints;
                }
            }
            return result;
        }
    }
}
