package oa.bluemoon.com.cn.lib_java;

import java.util.ArrayList;
import java.util.HashMap;
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
public class _121_Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {
        new _121_Best_Time_to_Buy_and_Sell_Stock().maxProfit(new int[]{1,4,2});
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
