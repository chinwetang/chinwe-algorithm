package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _0046_Permutations {
    public static void main(String[] args) {
        new _0046_Permutations().permute(new int[]{1, 2, 3});
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list=new ArrayList<>();
            list.add(nums[i]);
            listList.add(list);
        }
        return permute(nums,listList);
    }
    public List<List<Integer>> permute(int[] nums,List<List<Integer>> listList) {
        if(listList.get(0).size()==nums.length)
            return listList;
        List<List<Integer>> listList2 = new ArrayList<>();
        for (int i = 0; i < listList.size(); i++) {
            List<Integer> list=listList.get(i);
            for (int j = 0; j < nums.length; j++) {
                if(!list.contains(nums[j])){
                    List<Integer> integerList=new ArrayList<>(list);
                    integerList.add(nums[j]);
                    listList2.add(integerList);
                }
            }
        }
        return permute(nums,listList2);
    }
}
