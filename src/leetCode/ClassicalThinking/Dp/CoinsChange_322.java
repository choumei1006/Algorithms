package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/8 23:27
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 */
public class CoinsChange_322 {
    public static void main(String[] args) {
        System.out.println(coinChange2(new int[]{1,2,5},11));
    }
    public static  int coinChange(int[] coins,int amount ){
         if(coins.length == 0){
             return -1;
         }
         int[] nums = new int[amount+1];
         nums[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] >= 0  && nums[i-coins[j]] < min){
                    min = nums[i-coins[j]]+1;
                }
            }
            nums[i] = min;
        }
        return nums[amount] == Integer.MAX_VALUE ? -1 : nums[amount];
    }
    public static int coinChange2(int[] coins, int amount){
        if(null == coins || coins.length == 0){
            return -1;
        }
        int[] nums = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && nums[i - coins[j]] < min - 1){
                    min = nums[i - coins[j]] + 1;
                }
            }
            nums[i] = min;
        }
        return nums[amount] == Integer.MAX_VALUE ? -1 : nums[amount];

    }

    //=========================================2020-08-14自测=============================================
    @Test
    public void test(){
        System.out.println(coinChange4(new int[]{1, 2, 5}, 11));
    }

    /**
     * 找零钱:自上而下，无状态保存
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        //特判
        if (null == coins || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];    //dp数组
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] < min){
                    min = dp[i - coins[j]] + 1;
                }
                dp[i] = min;
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 找零钱：状态保存
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange5(int[] coins,int amount){
        if(amount < 1){
            return 0;
        }
        return coinChangeHelper(coins, amount, new int[amount]);
    }

    /**
     * 辅助类:amount金额最少的硬币数
     *
     * @param coins
     * @param amount
     * @param count   状态记忆
     * @return
     */
    private int coinChangeHelper(int[] coins, int amount, int[] count) {
        //特判
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if(count[amount - 1] != 0){
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = coinChangeHelper(coins, amount - coin, count);
            if(res >= 0 && res < min){
                min = res + 1;
            }
        }
        count[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount - 1];
    }

    /**
     * 找零钱：自底向上
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange4(int[] coins, int amount) {
        //特判
        if (null == coins || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);  //F(11)= min(F(11−1),F(11−2),F(11−5))
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
