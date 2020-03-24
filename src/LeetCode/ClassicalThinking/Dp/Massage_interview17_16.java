package LeetCode.ClassicalThinking.Dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/24 9:25
 * @Description: 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 *
 * //回溯法超时用例：
 * [114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240]
 */
public class Massage_interview17_16 {
    @Test
    public void test(){
        int[] nums = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.printf("用例:%s\n", Arrays.toString(nums));
        long beforeTime = System.currentTimeMillis();
        System.out.println("结果:"+massage1(nums));
        long afterTime = System.currentTimeMillis();
        System.out.printf("DP耗时：%d\n", afterTime-beforeTime);
    }


    /**
     * 方法一：动态规划（自底向上）
     * @param nums
     * @return
     */
    public int massage1(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }

    /**
     * 方法二：回溯法（自顶向下）
     * 【超时】
     * @param nums
     * @return
     */
    public int massage2(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        return getRecOpt(nums,nums.length-1);
    }
    public int getRecOpt(int[] nums, int i){
        if(null == nums || nums.length == 0){
            return 0;
        }
        return i == 0 ? nums[0] : i == 1 ? Math.max(nums[0],nums[1]) : Math.max(getRecOpt(nums,i-1),getRecOpt(nums,i-2)+nums[i]);
    }
}
