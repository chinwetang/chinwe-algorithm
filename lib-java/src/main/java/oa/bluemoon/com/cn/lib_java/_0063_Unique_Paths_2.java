package oa.bluemoon.com.cn.lib_java;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0063_Unique_Paths_2 {

    public static void main(String[] args) {
        int[][] it = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        new Solution().uniquePathsWithObstacles(it);
    }

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
                return 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] != 1) {
                        if (i == 0) {
                            if (j > 0 && (obstacleGrid[i][j - 1] == 1 || obstacleGrid[i][j - 1] == 0)) {
                                obstacleGrid[i][j] = 0;
                            } else {
                                obstacleGrid[i][j] = -1;
                            }
                        } else if (j == 0) {
                            if (i > 0 && (obstacleGrid[i - 1][j] == 1 || obstacleGrid[i - 1][j] == 0)) {
                                obstacleGrid[i][j] = 0;
                            } else {
                                obstacleGrid[i][j] = -1;
                            }
                        } else {
                            if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                                obstacleGrid[i][j] = 0;
                            } else if (obstacleGrid[i - 1][j] == 1) {
                                obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                            } else if (obstacleGrid[i][j - 1] == 1) {
                                obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                            } else {
                                obstacleGrid[i][j] =
                                        obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                            }
                        }
                    }
                }
            }
            return obstacleGrid[m - 1][n - 1] == 1 ? 0 : -obstacleGrid[m - 1][n - 1];
        }
    }

    static class Solution2 {
//        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//
//        }

        Map<String, Integer> map = new HashMap<>();

        public int uniquePaths(int m, int n) {
            if (m == 1 || n == 1)
                return 1;
            String key = new StringBuilder().append(m * n).append("-").append(m + n).toString();
            Integer value = map.get(key);
            if (value != null) {
                return value;
            } else {
                int v = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
                map.put(key, v);
                return v;
            }
        }
    }
}
