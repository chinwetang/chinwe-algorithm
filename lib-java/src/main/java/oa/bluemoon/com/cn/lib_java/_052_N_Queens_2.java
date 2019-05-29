package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class _052_N_Queens_2 {

    public static void main(String[] args) {
        new _052_N_Queens_2().totalNQueens(4);
    }

    int result = 0;
    List<String> cache = new ArrayList<>();

    public int totalNQueens(int n) {
        char S = 'Q', U = '.';
        StringBuffer buffer = new StringBuffer();
        for (int i = n; i > 0; i--) {
            buffer.delete(0, buffer.length());
            for (int j = n; j > 0; j--) {
                buffer.append(j == i ? S : U);
            }
            cache.add(buffer.toString());
        }
        solveNQueens(new ArrayList<String>(), new int[n][n], n);
        return result;
    }

    public void solveNQueens(List<String> list, int[][] record, int n) {
        if (list.size() == n) {
            if (cache.indexOf(list.get(0)) < n / 2) {
                result += 2;
            } else {
                result++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 && i >= (n + 1) / 2) {
                //轴对称，只需要循环一半
                break;
            }
            //先判断能不能入队
            int j = list.size();
            if (record[j][i] == 0) {
                List<String> newList = new ArrayList<>(list);
                int[][] newRecord = new int[n][n];
                for (int q = 0; q < n; q++) {
                    for (int p = 0; p < n; p++) {
                        newRecord[q][p] = record[q][p];
                    }
                }
                newList.add(cache.get(i));
                for (int q = 0; q < n; q++) {
                    for (int p = 0; p < n; p++) {
                        if (q == j || p == i || Math.abs(q - j) == Math.abs(p - i))
                            newRecord[q][p] = 1;
                    }
                }
                solveNQueens(newList, newRecord, n);
            } else {
                continue;
            }
        }
    }
}
