package oa.bluemoon.com.cn.lib_java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0062_Unique_Paths {

    public static void main(String[] args) {
        new Solution().uniquePaths(7, 3);
    }

    static class Solution {
        Map<String, Integer> map = new HashMap<>();

        public int uniquePaths(int m, int n) {
            if (m == 1 || n == 1)
                return 1;
            String key = new StringBuffer().append(m * n).append("-").append(m + n).toString();
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


    static class Solution2 {
        public int uniquePaths(int m, int n) {
            int[][] paths = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0)
                        paths[i][j] = 1;
                    else
                        paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
            return paths[m - 1][n - 1];
        }
    }

    static class Solution3 {
        public int uniquePaths(int m, int n) {
            int[][] paths = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0)
                        paths[i][j] = 1;
                    else
                        paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
            return paths[m - 1][n - 1];
        }
    }
}
