package oa.bluemoon.com.cn.lib_java;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0028_Implement_strStr {
    static class Solution {


        public int strStr(String haystack, String needle) {
            return bm(haystack.toCharArray(), haystack.length(), needle.toCharArray(),
                    needle.length());
        }

        private static final int SIZE = 256; // 全局变量或成员变量

        private void generateBC(char[] b, int m, int[] bc) {
            for (int i = 0; i < SIZE; ++i) {
                bc[i] = -1; // 初始化 bc
            }
            for (int i = 0; i < m; ++i) {
                int ascii = (int) b[i]; // 计算 b[i] 的 ASCII 值
                bc[ascii] = i;
            }
        }

        // a,b 表示主串和模式串；n，m 表示主串和模式串的长度。
        public int bm(char[] a, int n, char[] b, int m) {
            int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
            generateBC(b, m, bc); // 构建坏字符哈希表
            int[] suffix = new int[m];
            boolean[] prefix = new boolean[m];
            generateGS(b, m, suffix, prefix);
            int i = 0; // j 表示主串与模式串匹配的第一个字符
            while (i <= n - m) {
                int j;
                for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                    if (a[i + j] != b[j]) break; // 坏字符对应模式串中的下标是 j
                }
                if (j < 0) {
                    return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                }
                int x = j - bc[(int) a[i + j]];
                int y = 0;
                if (j < m - 1) { // 如果有好后缀的话
                    y = moveByGS(j, m, suffix, prefix);
                }
                i = i + Math.max(x, y);
            }
            return -1;
        }

        // j 表示坏字符对应的模式串中的字符下标 ; m 表示模式串长度
        private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
            int k = m - 1 - j; // 好后缀长度
            if (suffix[k] != -1) return j - suffix[k] + 1;
            for (int r = j + 2; r <= m - 1; ++r) {
                if (prefix[m - r] == true) {
                    return r;
                }
            }
            return m;
        }

        // b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
        private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
            for (int i = 0; i < m; ++i) { // 初始化
                suffix[i] = -1;
                prefix[i] = false;
            }
            for (int i = 0; i < m - 1; ++i) { // b[0, i]
                int j = i;
                int k = 0; // 公共后缀子串长度
                while (j >= 0 && b[j] == b[m - 1 - k]) { // 与 b[0, m-1] 求公共后缀子串
                    --j;
                    ++k;
                    suffix[k] = j + 1; //j+1 表示公共后缀子串在 b[0, i] 中的起始下标
                }
//                i
                if (j == -1) prefix[k] = true; // 如果公共后缀子串也是模式串的前缀子串
            }
        }


    }
}
