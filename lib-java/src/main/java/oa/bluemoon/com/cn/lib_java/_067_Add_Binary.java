package oa.bluemoon.com.cn.lib_java;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class _067_Add_Binary {
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        StringBuffer buffer = new StringBuffer();
        boolean isPlusOne = false;
        while (aLength > 0 || bLength > 0) {
            int i = 0;
            if (aLength > 0 && a.charAt(--aLength) == '1') i++;
            if (bLength > 0 && b.charAt(--bLength) == '1') i++;
            if (isPlusOne) i++;
            if(i%2==0){
                buffer.insert(0,'0');
            }else{
                buffer.insert(0,'1');
            }
            isPlusOne=i>1;
        }
        if(isPlusOne){
            buffer.insert(0,'1');
        }
        return buffer.toString();
    }
}
