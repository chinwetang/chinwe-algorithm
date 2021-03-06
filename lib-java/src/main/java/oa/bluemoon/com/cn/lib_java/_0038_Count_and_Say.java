package oa.bluemoon.com.cn.lib_java;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class _0038_Count_and_Say {
    public static void main(String[] args) {

    }

    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().countAndSay(40));
        }

        public String countAndSay(int n) {
            String result = "1";
            StringBuffer buffer = new StringBuffer();

            for (int i = 2; i <= n; i++) {
                char c = ' ';
                int num = 0;
                for (int j = 0; j <= result.length(); j++) {
                    if (j == result.length() || result.charAt(j) != c) {
                        if (num > 0) {
                            buffer.append(num).append(c);
                        }
                        if (j < result.length())
                            c = result.charAt(j);
                        num = 1;
                    } else {
                        num++;
                    }
                }
                result = buffer.toString();
                buffer.delete(0, result.length());
            }
            return result;
        }
    }
}
