package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
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
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class _051_N_Queens {

    public static void main(String[] args) {
        new Solution3().solveNQueens(4);
    }

    static class Solution1{
        List<List<String>> result = new ArrayList<>();
        List<String> cache = new ArrayList<>();


        public List<List<String>> solveNQueens(int n) {
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
                result.add(list);
                return;
            }
            for (int i = 0; i < n; i++) {
                //先判断能不能入队
                int j = list.size();
                if (record[j][i] == 0) {
                    List<String> newList = new ArrayList<>(list);
                    int[][] newRecord = new int[n][n];
                    for (int q = 0; q < n; q++) {
                        for (int p = 0; p < n; p++) {
                            newRecord[q][p]=record[q][p];
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

    /**
     * map的COPY太费时间了
     */
    static class Solution2{

        List<List<String>> result = new ArrayList<>();


        public List<List<String>> solveNQueens(int n) {
            char S = 'Q', U = '.';
            StringBuffer buffer = new StringBuffer();
            Map<Integer, String> cache = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    buffer.append(j == i ? S : U);
                }
                cache.put(i,buffer.toString());
                buffer.delete(0, buffer.length());
            }
            for (int i = n; i > 0; i--) {
                buffer.delete(0, buffer.length());
                for (int j = n; j > 0; j--) {
                    buffer.append(j == i ? S : U);
                }
            }
            solveNQueens(new ArrayList<String>(),cache, new int[n][n], n);
            return result;
        }

        public void solveNQueens(List<String> list,Map<Integer, String> cache, int[][] record, int n) {
            if (list.size() == n) {
                result.add(list);
                return;
            }
            for (Integer key : cache.keySet()) {
                //先判断能不能入队
                int j = list.size();
                if (record[j][key] == 0) {
                    List<String> newList = new ArrayList<>(list);
                    Map<Integer, String> newCache=new HashMap<>(cache);
                    int[][] newRecord = new int[n][n];
                    for (int q = 0; q < n; q++) {
                        for (int p = 0; p < n; p++) {
                            newRecord[q][p] = record[q][p];
                        }
                    }
                    newList.add(cache.get(key));
                    newCache.remove(key);
                    for (int q = 0; q < n; q++) {
                        for (int p = 0; p < n; p++) {
                            if (q == j || p == key || Math.abs(q - j) == Math.abs(p - key))
                                newRecord[q][p] = 1;
                        }
                    }
                    solveNQueens(newList,newCache, newRecord, n);
                } else {
                    continue;
                }
            }
        }
    }


    /**
     * 动态改变缓存池使用太费时间
     */
    static class Solution4{
        List<List<String>> result = new ArrayList<>();
        char S = 'Q', U = '.';


        public List<List<String>> solveNQueens(int n) {
            StringBuffer buffer = new StringBuffer();
            List<String> cache = new ArrayList<>();
            for (int i = n; i > 0; i--) {
                buffer.delete(0, buffer.length());
                for (int j = n; j > 0; j--) {
                    buffer.append(j == i ? S : U);
                }
                cache.add(buffer.toString());
            }
            solveNQueens(new ArrayList<String>(),cache, new int[n][n], n);
            return result;
        }

        public void solveNQueens(List<String> list,List<String> cache, int[][] record, int n) {
            if (list.size() == n) {
                result.add(list);
                return;
            }
            for (String s : cache) {
                //先判断能不能入队
                int i=s.indexOf(S);
                int j = list.size();
                if (record[j][i] == 0) {
                    List<String> newList = new ArrayList<>(list);
                    List<String> newCache=new ArrayList<>(cache);
                    int[][] newRecord = new int[n][n];
                    for (int q = 0; q < n; q++) {
                        for (int p = 0; p < n; p++) {
                            newRecord[q][p]=record[q][p];
                        }
                    }
                    newCache.remove(s);
                    newList.add(s);
                    for (int q = 0; q < n; q++) {
                        for (int p = 0; p < n; p++) {
                            if (q == j || p == i || Math.abs(q - j) == Math.abs(p - i))
                                newRecord[q][p] = 1;
                        }
                    }
                    solveNQueens(newList, newCache,newRecord, n);
                } else {
                    continue;
                }
            }
        }
    }

    /**
     * 发现轴对称，可以省一半
     */
    static class Solution3{
        List<List<String>> result = new ArrayList<>();
        List<String> cache = new ArrayList<>();


        public List<List<String>> solveNQueens(int n) {
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
                result.add(list);
                if (cache.indexOf(list.get(0)) < n / 2) {
                    List<String> symmetry=new ArrayList<>();
                    StringBuffer buffer=new StringBuffer();
                    for (String s : list) {
                        symmetry.add(buffer.append(s).reverse().toString());
                        buffer.delete(0,buffer.length());
                    }
                    result.add(symmetry);
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
                            newRecord[q][p]=record[q][p];
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


}
