package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class _0326_Power_of_Three {
    public static void main(String[] args) {

    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return Math.abs(n) == 1;
    }

    public boolean isPowerOfThree2(int n) {
        if (n <= 0)
            return false;
        String str=Integer.toString(n, 3);//转为3进制
        return str.lastIndexOf("1")==0&&str.indexOf("2")==-1;//首位为1且其余位为0即为3的n次幂
    }
}
