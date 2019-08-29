package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1122_Relative_Sort_Array {

    static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> map = new HashMap<>(arr2.length);
            for (int i = 0; i < arr2.length; i++) {
                map.put(arr2[i], i);
            }
            List<List<Integer>> lists=new ArrayList<>();
            for (int i = 0; i <= arr2.length; i++) {
                lists.add(new ArrayList<Integer>());
            }
            for (int i : arr1) {
                Integer p=map.get(i);
                if(p==null) p=arr2.length;
                lists.get(p).add(i);
            }
            int[] result=new int[arr1.length];
            int i=0;
            for (List<Integer> list : lists) {
                for (Integer integer : list) {
                    result[i++]=integer;
                }
            }
            Arrays.sort(result,result.length-lists.get(arr2.length).size(),result.length);
            return result;
        }
    }
}
