package oa.bluemoon.com.cn.lib_java;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class _0029_Divide_Two_Integers {

    /**
     * 超时间限制
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;

        int result = 0;

        boolean identical = dividend > 0 ^ divisor < 0;

        for (; ; ) {
            if (identical) {
                dividend -= divisor;
            } else {
                dividend += divisor;
            }
            if (dividend == 0 || (dividend > 0 ^ divisor < 0) == identical) {
                if (identical) {
                    result++;
                } else {
                    result--;
                }
            }
            if (dividend == 0 || (dividend > 0 ^ divisor < 0) != identical) {
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.print(new Solution().divide(-7,
                -3));
    }

    static class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == divisor) {
                return 1;
            }
            if (divisor == -2147483648||dividend==0) {
                return 0;
            }
            int res = dividend >>> 31 ^ divisor >>> 31;
            dividend = Math.abs(dividend + (res == 1 ? 1 : -1) * divisor);
            divisor = Math.abs(divisor);
            int result = 1;
            if(dividend==0)
                return result;
            if (dividend < divisor) {
                result--;
            }
            while (dividend >= divisor) {
                for (int i = 1; ; i++) {
                    if (divisor << i > dividend) {
                        int old = result;
                        int pow = (int) Math.pow(2, i - 1);
                        result += pow;
                        if (result - pow != old) {
                            return 2147483647;
                        }
                        dividend -= divisor << (i - 1);
                        break;
                    }
                }
            }
            return result * (res == 1 ? -1 : 1);
        }


    }
}
