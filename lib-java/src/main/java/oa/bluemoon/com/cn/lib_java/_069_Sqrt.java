package oa.bluemoon.com.cn.lib_java;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class _069_Sqrt {

    public static void main(String[] args) {
        new Solution().mySqrt(8);
    }

    static class Solution {
        public int mySqrt(int x) {
            return mySqrt(0, x, x);
        }

        public int mySqrt(int start, int end, int x) {
            if (end - start<=1) {
                if(Math.pow(end,2)<=x)
                    return end;
                else
                    return start;
            }
            int m = (end - start) / 2 + start;
            double mS = Math.pow(m, 2);
            if (mS > x) {
                return mySqrt(start, m, x);
            } else if (mS < x) {
                return mySqrt(m, end, x);
            } else {
                return m;
            }
        }
    }
}
