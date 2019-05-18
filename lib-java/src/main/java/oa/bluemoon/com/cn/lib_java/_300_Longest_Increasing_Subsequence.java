package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class _300_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        new _300_Longest_Increasing_Subsequence().lengthOfLIS4(new int[]{10, 22, 9, 33, 21, 50,
                41, 60, 80});
    }

    public int lengthOfLIS(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> listList2 = new ArrayList<>();
            for (int j = 0; j < listList.size(); j++) {
                List<Integer> list = listList.get(j);
                if (nums[i] > list.get(list.size() - 1)) {
                    if (nums[i] - list.get(list.size() - 1) > 1) {
                        listList2.add(new ArrayList<>(list));
                    }
                    list.add(nums[i]);
                    maxLength = Math.max(list.size(), maxLength);
                }
            }
            listList.addAll(listList2);

            Iterator<List<Integer>> it = listList.iterator();
            while (it.hasNext()) {
                List<Integer> list = it.next();
                if (list.get(list.size() - 1) >= nums[i] && list.size() < maxLength) {
                    ((Iterator) it).remove();
                }
            }


            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            listList.add(list);

            maxLength = 0;
        }
        int result = 0;
        for (List<Integer> list : listList) {
            result = Math.max(result, list.size());
        }
        return result;
    }


    public int lengthOfLIS2(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> listList2 = new ArrayList<>();
            Iterator<List<Integer>> it = listList.iterator();
            while (it.hasNext()) {
                List<Integer> list = it.next();
                Integer length = map.get(nums[i]);
                if (length == null) length = 0;
                if (nums[i] > list.get(list.size() - 1)) {
                    if (nums[i] - list.get(list.size() - 1) > 1) {
                        listList2.add(new ArrayList<>(list));
                    }
                    list.add(nums[i]);
                    if (list.size() < length) {
                        it.remove();
                    } else {
                        length = list.size();
                    }
                } else if (list.size() <= length) {
                    it.remove();
                }
                map.put(nums[i], length);
            }
            listList.addAll(listList2);

            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            listList.add(list);
        }
        int result = 0;
        for (List<Integer> list : listList) {
            result = Math.max(result, list.size());
        }
        return result;
    }


    public int lengthOfLIS3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer length = map.get(nums[i]);
            if (length == null) {
                length = 1;
            }
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (entry.getKey() > nums[i] && entry.getValue() <= length) {
                    it.remove();
                }
                if (entry.getKey() < nums[i]) {
                    length = Math.max(entry.getValue() + 1, length);
                }
            }
            map.put(nums[i], length);
        }
        int result = 0;
        for (Integer key : map.keySet()) {
            result = Math.max(result, map.get(key));
        }
        return result;
    }


    public int lengthOfLIS4(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
