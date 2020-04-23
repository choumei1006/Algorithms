package LeetCode.ClassicalThinking.Dp;

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
}
