package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/3/9 18:48
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */
public class MaxProfit_121 {
    @Test
    public void test(){
        System.out.println(maxProfit3(new int[]{7,2,8,3,1,5,4}));
    }

    /**
     * 方法一：暴力
     * @param prices
     * @return
     */
    public static int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit  = profit;
            }
        }
        return maxprofit;

    }

    /**
     * 方法二：动态规划
     * @param prices
     * @return
     */
    public static int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    /**
     * 自测
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices){
        //特判
        if(null == prices || prices.length == 0){
            return -1;
        }

        int res = Integer.MIN_VALUE;  //结果：最大利润
        int minPrice = Integer.MAX_VALUE;    //当前最低股票价格

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > res){
                res = prices[i] - minPrice;
            }
        }
        return res;
    }
}
