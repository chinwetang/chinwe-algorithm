package oa.bluemoon.com.cn.lib_java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class _149_Max_Points_on_a_Line {

    public static void main(String[] args) {
//        String s=new String("[[0,-12],[5,2],[2,5],[0,-5],[1,5],[2,-2],[5,-4],[3,4],[-2,4],[-1,4],[0,-5],[0,-8],[-2,-1],[0,-11],[0,-9]]");
//        String newS=s.replace('[','{').replace(']','}');

        new Solution().maxPoints(new int[][]{{0,-12},{5,2},{2,5},{0,-5},{1,5},{2,-2},{5,-4},{3,4},{-2,4},{-1,4},{0,-5},{0,-8},{-2,-1},{0,-11},{0,-9}});
    }



    static class Solution {

        static class Dot{
            public Dot(int[] ints){
                x=ints[0];
                x=ints[1];
            }

            int x;
            int y;

            @Override
            public String toString() {
                return new StringBuffer().append(x).append(",").append(y).toString();
            }

            @Override
            public boolean equals(Object o) {
                return o.toString().equals(toString());
            }

            @Override
            public int hashCode() {
                return toString().hashCode();
            }
        }

        public int maxPoints(int[][] points) {
            int result = 0;

            /**
             * 第一步，先把相同的点归类出来
             */
            Map<Dot, Integer> cahce = new HashMap<>();
            for (int[] point : points) {
                Dot key=new Dot(point);
                Integer num = cahce.get(key);
                if (num == null) {
                    num = 0;
                }
                num++;
                cahce.put(key, num);
            }

            /**
             * 第二步，把相同角度的点归类出来
             */
            Map<Double, Set<Dot>> map = new HashMap<>();
            for (Dot key1 : cahce.keySet()) {
                for (Dot key2 : cahce.keySet()) {
                    if (!key1.equals(key2)) {
                        Double key = (key1.x - key2.x) * 1d / (key1.y - key2.y);
                        Set<Dot> set = map.get(key);
                        if (set == null) {
                            set = new HashSet<>();
                        }
                        set.add(key1);
                        set.add(key2);
                        map.put(key, set);
                    }
                }
            }

            /**
             * 第三步，遍历，求最大值
             */
            for (Double key : map.keySet()) {
                int x = 0;
                for (Dot d : map.get(key)) {
                    x += cahce.get(d);
                }
                result = Math.max(result, x);
            }
            return result == 0 ? points.length : result;
        }
    }
}
