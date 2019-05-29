package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _047_Permutations_2 {
    public static void main(String[] args) {
        new _047_Permutations_2().permuteUnique(new int[]{1, 1, 3});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> map=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer num=map.get(nums[i]);
            if(num==null)
                num=0;
            map.put(nums[i],++num);
        }
        List<List<Integer>> listList =new ArrayList<>();
        listList.add(new ArrayList<Integer>());
        return permute(nums,map,listList);
    }

    public List<List<Integer>> permute(int[] nums,Map<Integer,Integer> map,List<List<Integer>> listList) {
        if(listList.get(0).size()==nums.length)
            return listList;
        List<List<Integer>> listList2 = new ArrayList<>();
        for (int i = 0; i < listList.size(); i++) {
            Map<Integer,Integer> map2=new HashMap<>(map);
            List<Integer> list=listList.get(i);
            for (int j = 0; j < list.size(); j++) {
                map2.put(list.get(j),map2.get(list.get(j))-1);
            }
            for (Integer key : map2.keySet()) {
                if(map2.get(key)>0){
                    List<Integer> integerList=new ArrayList<>(list);
                    integerList.add(key);
                    listList2.add(integerList);
                }
            }
        }
        return permute(nums,map,listList2);
    }
}
