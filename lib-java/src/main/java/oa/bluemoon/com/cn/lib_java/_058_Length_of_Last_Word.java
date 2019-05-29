package oa.bluemoon.com.cn.lib_java;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class _058_Length_of_Last_Word {
    public static void main(String[] args) {
    }


    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) != ' ') {
                result++;
            }else if(result==0){
                continue;
            }else {
                break;
            }
        }
        return result;
    }
}
