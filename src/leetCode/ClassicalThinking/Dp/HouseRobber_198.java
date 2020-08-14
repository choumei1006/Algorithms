package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/5/29 8:41
 * @Description: 【打家劫舍】
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 */
public class HouseRobber_198 {
    @Test
    public void test(){
        //System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob3(new int[]{2,7,9,3,1}));
    }

    /**
     * 方法一：动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums){
        //特判
        if(null == nums || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }


        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int maxProfit = Math.max(dp[0], dp[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);   //间隔选取
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }

    /**
     * 方法二：精简，笔试场景练习
     * @return
     */
    public void rob2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //数组元素个数
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        if(n == 0){
            //return 0;
            System.out.println(0);
        }
        if(n == 1){
            //return list.get(0);
            System.out.println(list.get(0));
        }

        int pre = 0, cur = 0, tmp;
        for(int num : list){
            tmp = cur;
            cur = Math.max(num + pre, cur);
            pre = tmp;
        }
        //return cur;
        System.out.println(cur);
    }

    public int rob3(int[] nums){
        int n = nums.length;
        if(n == 0){
            return 0;
            //System.out.println(0);
        }
        if(n == 1){
            return nums[0];
        }

        int pre = 0, cur = 0, tmp;
        for(int num : nums){
            tmp = cur;
            cur = Math.max(num + pre, cur);
            pre = tmp;
        }
        return cur;
    }
}
