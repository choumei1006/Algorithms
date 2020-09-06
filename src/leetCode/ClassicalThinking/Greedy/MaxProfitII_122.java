package leetCode.ClassicalThinking.Greedy;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/5 10:54
 * @Description:  【买卖股票最大收益II】
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 */
public class MaxProfitII_122 {
    public static void main(String[] args) {
        //接收输入
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入价格数组长度：");
        int n = sc.nextInt();   //数组长度

        sc.nextLine();

        int[] prices = new int[n];
        System.out.println("请输入价格：");
        String inputPrices = sc.nextLine().trim();
        String[] pricesStr = inputPrices.split("\\s+");
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(pricesStr[i]);
        }

        System.out.println("您能获取的最大利润为："+ maxProfit2(prices));
    }


    /**
     * 方法一：峰谷法
     * 获取连续的谷峰差值
     * @param prices
     * @return
     */
    public static  int maxProfit(int[] prices){
        //特判
        if(null == prices || prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        //遍历，获取连续的谷值、峰值
        int valley = prices[0];   //谷值
        int peak = prices[0];   //峰值
        int idx = 0;
        while (idx < prices.length - 1) {
            //寻找谷值
            while (idx < prices.length - 1 && prices[idx] >= prices[idx + 1]) {
                idx++;
            }
            valley = idx;
            while(idx < prices.length - 1 && prices[idx] <= prices[idx + 1]){
                idx++;
            }
            peak = idx;
            maxProfit += prices[peak] - prices[valley];
        }
        return maxProfit;
    }

    /**
     * 方法二：简单遍历
     * 思路：该解决方案遵循 方法一 的本身使用的逻辑，但有一些轻微的变化。
     * 在这种情况下，我们可以简单地继续在斜坡上爬升并持续增加从连续交易中获得的利润，
     * 而不是在谷之后寻找每个峰值。
     * 最后，我们将有效地使用峰值和谷值，但我们不需要跟踪峰值和谷值对应的成本以及最大利润，
     * 但我们可以直接继续增加加数组的连续数字之间的差值，如果第二个数字大于第一个数字，
     * 我们获得的总和将是最大利润。这种方法将简化解决方案。
     * 这个例子可以更清楚地展现上述情况：
     * <p>
     * [1, 7, 2, 3, 6, 7, 6, 7]
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        //特判
        if (null == prices || prices.length == 0) {
            return 0;
        }

        //遍历查找所有上升区间，加到利润中
        int maxProfit = 0;
        int idx = 0;
        while(idx < prices.length - 1){
            if(prices[idx] < prices[idx + 1]){
                maxProfit += prices[idx + 1] - prices[idx];
            }
            idx++;
        }
        return maxProfit;
    }
}
