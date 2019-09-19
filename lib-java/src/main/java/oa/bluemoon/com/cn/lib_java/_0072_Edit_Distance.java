package oa.bluemoon.com.cn.lib_java;

import java.util.Arrays;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0072_Edit_Distance {

    /**
     * 动态规划-状态转移方程
     */
    static class Solution {
        public int minDistance(String word1, String word2) {

            int[][] words = new int[word1.length() + 1][word2.length() + 1];

            for (int i = 0; i <= word1.length(); i++) {
                words[i][0] = i;
            }

            for (int i = 0; i <= word2.length(); i++) {
                words[0][i] = i;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        words[i][j] = words[i - 1][j - 1];
                    } else {
                        words[i][j] = Math.min(
                                Math.min(words[i - 1][j - 1], words[i][j - 1]),
                                words[i - 1][j]) + 1;
                    }
                }
            }

            return words[word1.length()][word2.length()];
        }
    }


}
