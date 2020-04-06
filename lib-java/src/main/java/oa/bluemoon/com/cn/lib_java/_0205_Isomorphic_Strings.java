package oa.bluemoon.com.cn.lib_java;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0205_Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {
        //存映射关系
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character cs = s.charAt(i), ct = t.charAt(i);
            Character left = map.get(cs);
            if (ct.equals(left))
                continue;
            if (left == null && !map.containsValue(ct)) {
                map.put(cs, ct);
                continue;
            }
            return false;

        }
        return true;
    }
}
