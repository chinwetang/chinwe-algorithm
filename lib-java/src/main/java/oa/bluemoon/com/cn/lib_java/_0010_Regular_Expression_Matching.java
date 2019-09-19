package oa.bluemoon.com.cn.lib_java;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0010_Regular_Expression_Matching {

    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().isMatch("afdfd", "ab*c*d*fdfd"));
        }

        public boolean isMatch(String s, String p) {
            return isMatch(s, p, 0, 0);
        }

        public boolean isMatch(String s, String p, int sP, int pP) {
            int nSP = sP, nPP = pP;
            int first = p.indexOf('*', pP);
            for (; ; ) {
                if (nSP == s.length() && nPP == p.length())
                    return true;
                if (nPP == p.length())
                    return false;
                if (nSP == s.length() || (first != -1 && nPP >= first - 1))
                    break;
                if (p.charAt(nPP) != '.' && s.charAt(nSP) != p.charAt(nPP))
                    return false;
                nSP++;
                nPP++;
            }
            if (first - 1 != nPP)
                return false;
            int i = nSP;
            char c = p.charAt(nPP);
            while (i < s.length() && (c == '.' || s.charAt(i) == c)) {
                i++;
            }
            for (int j = 0; j <= i - nSP; j++) {
                if (isMatch(s, p, nSP + j, nPP + 2)) {
                    return true;
                }
            }
            return false;
        }
    }
}
