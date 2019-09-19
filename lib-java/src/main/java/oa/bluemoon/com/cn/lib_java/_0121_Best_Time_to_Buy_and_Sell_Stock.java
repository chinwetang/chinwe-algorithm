package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class _0121_Best_Time_to_Buy_and_Sell_Stock {

    static class Solution {

        public static void main(String[] args) {
            System.out.println(new Solution().maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
        }

        public int maxProfit(int[] prices) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            int result = 0;
            for (int i = 0; i < prices.length; i++) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Integer temp = queue.poll();
                    if (temp < 1 && (i == prices.length - 1 || prices[i] > prices[i + 1]) && temp + prices[i] > 0) {
                        //卖
                        result = Math.max(temp + prices[i], result);
                    }
                    if (temp == 1 && i < prices.length - 1 && prices[i] < prices[i + 1]) {
                        //买
                        queue.offer(-prices[i]);
                    }
                    //原地不动，不买不卖
                    queue.offer(temp);
                }
            }
            return result;
        }
    }

    static class Solution2 {

        public static void main(String[] args) {
            System.out.println(new Solution2().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        }

        public int maxProfit(int[] prices) {
            int min = -1, resMax = 0;
            for (int i = 0; i < prices.length; i++) {
                if (i < prices.length - 1 && prices[i] < prices[i + 1] && (i == 0 || prices[i] <= prices[i - 1])) {
                    //谷底
                    min = min < 0 ? prices[i] : Math.min(prices[i], min);
                }
                if (min >= 0 && i > 0 && prices[i] > prices[i - 1] && (i == prices.length - 1 || prices[i] >= prices[i + 1])) {
                    //找到谷底之后的峰顶
                    resMax = Math.max(resMax, prices[i] - min);
                }
            }
            return resMax;
        }
    }

    public static void main(String[] args) {
        new _0121_Best_Time_to_Buy_and_Sell_Stock().maxProfit(new int[]{1, 4, 2});
    }

    public int maxProfit(int[] prices) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        int minKey = -1;
        for (int i = 0; i < prices.length; i++) {
            for (Integer key : map.keySet()) {
                if (prices[i] > prices[map.get(key)]) {
                    if (minKey == -1) {
                        minKey = key;
                    } else if (prices[key] < prices[minKey]) {
                        minKey = key;
                    }
                    keys.add(key);
                    map.put(key, i);
                }
            }
            for (Integer key : keys) {
                if (key != minKey) {
                    map.remove(key);
                }
            }
            if (i < prices.length - 1 && prices[i] < prices[i + 1])
                map.put(i, i);

            keys.clear();
            minKey = -1;
        }

        int result = 0;
        for (Integer key : map.keySet()) {
            result = Math.max(result, prices[map.get(key)] - prices[key]);
        }
        return result;
    }

}
