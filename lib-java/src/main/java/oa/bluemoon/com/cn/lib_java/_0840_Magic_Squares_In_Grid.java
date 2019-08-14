package oa.bluemoon.com.cn.lib_java;

import java.util.HashSet;
import java.util.Set;

/**
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * <p>
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * <p>
 * 而这一个不是：
 * 384
 * 519
 * 762
 * <p>
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-squares-in-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0840_Magic_Squares_In_Grid {


    static class Solution {
        public static void main(String[] args) {
            new Solution().test();
        }

        public void test() {
            int x = 0, y = 0;
            for (int k = 0; k < 8; k++) {
                System.out.println(x + "," + y);
                if (y < 2 && x <= y) {
                    y++;
                } else if (y == 2 && x < 2) {
                    x++;
                } else if (y > 0 && x == 2) {
                    y--;
                } else if (y == 0) {
                    x--;
                }
            }
        }

        public int numMagicSquaresInside(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int result = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < m - 2; i++) {
                for (int j = 0; j < n - 2; j++) {
                    if (grid[i + 1][j + 1] != 5)
                        continue;
                    set.add(grid[i + 1][j + 1]);
                    boolean yes = true;
                    int x = 0, y = 0;
                    for (int k = 0; k < 8; k++) {
                        if (set.contains(grid[x + i][y + j])) {
                            yes = false;
                            break;
                        }else{
                            set.add(grid[x + i][y + j]);
                        }
                        if (y < 2 && x <= y) {
                            y++;
                        } else if (y == 2 && x < 2) {
                            x++;
                        } else if (y > 0 && x == 2) {
                            y--;
                        } else if (y == 0) {
                            x--;
                        }
                    }
                    result++;
                }
            }
            return result;
        }
    }

}
