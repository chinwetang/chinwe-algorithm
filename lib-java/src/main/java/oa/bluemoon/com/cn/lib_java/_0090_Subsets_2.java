package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0090_Subsets_2 {

    public static void main(String[] args) {
        new Solution().subsetsWithDup(new int[]{1, 2, 2});
    }


    static class Solution {


        public List<List<Integer>> subsetsWithDup(int[] nums) {

            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                Integer value = map.get(num);
                if (value == null) {
                    value = 1;
                } else {
                    value++;
                }
                map.put(num, value);
            }
            List<List<Integer>> res = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                List<List<Integer>> listList = new ArrayList<>();
                for (Integer i = 0; i <= entry.getValue(); i++) {
                    for (List<Integer> integers : listList) {
                        integers.add(entry.getKey());
                    }
                    listList.add(new ArrayList<>());
                }
                int size = res.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> list = res.remove(0);
                    if (list.size() != 0)
                        for (int j = 0; j < listList.size(); j++) {
                            List<Integer> list1 = new ArrayList<>(list);
                            list1.addAll(listList.get(j));
                            res.add(list1);
                        }
                }
                for (int i = 0; i < listList.size(); i++) {
                    res.add(listList.get(i));
                }
            }

            return res;
        }


//        public List<List<Integer>> subsetsWithDup(int[] nums,int start) {
//            List<List<Integer>>
//            if(nums.length==start) return
//        }
    }
}
