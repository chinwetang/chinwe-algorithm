package oa.bluemoon.com.cn.lib_java;

/**
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 * <p>
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出："110"
 * 解释：(-2) ^ 2 + (-2) ^ 1 = 2
 * 示例 2：
 * <p>
 * 输入：3
 * 输出："111"
 * 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * 示例 3：
 * <p>
 * 输入：4
 * 输出："100"
 * 解释：(-2) ^ 2 = 4
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-to-base-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1017_Convert_to_Base__2 {

    public static void main(String[] args) {
        new Solution().baseNeg2(0);
    }

    static class Solution {
        public String baseNeg2(int N) {
            int iteration = N;
            char[] chars = new char[31];
            //i 表示第几位
            for (int i = 31; i > 1; i -= 2) {
                if (iteration == 0 || iteration < Math.pow(2, i - 2)) {
                    chars[31 - i] = '0';
                    chars[31 - i + 1] = '0';
                } else if (iteration >= Math.pow(2, i - 1)) {
                    chars[31 - i] = '1';
                    chars[31 - i + 1] = '0';
                    iteration -= Math.pow(2, i - 1);
                } else {
                    chars[31 - i] = '1';
                    chars[31 - i + 1] = '1';
                    iteration -= Math.pow(2, i - 2);
                }
            }
            chars[30] = iteration % 2 == 0 ? '0' : '1';
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar == '0' && i < chars.length - 1 && builder.length() == 0)
                    continue;
                if (builder.length() == 0 && iteration >= 2) {
                    builder.append("11");
                }
                builder.append((iteration >= 2 && i != chars.length - 1) ^ aChar == '1' ? '1' :
                        '0');
            }
            return builder.toString();
        }
    }

}
