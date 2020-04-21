package LeetCode.ClassicalThinking.Dp;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/21 18:52
 * @Description: Given an integer array nums, find the contiguous
 * subarray within an array( containing at least one number) which has the
 * largest sum.
 *
 * Example 1：
 * input： 【1，2，-2，4】
 * output：7
 * Explaination:[2,3,-2,4]has the largest sum 7;
 *
 * Example 2：
 * input： 【-2,0,-1】
 * output：0
 * Explaination:[2,3,-2,4]has the largest sum 7;
 *
 * 求数组中和最大的子数组之和；
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 */
public class SubarrayWithLargestSum_53 {
    @Test
    public void test(){
        System.out.println(getLargestSum(new int[]{1,2,-2,4}));
    }

    /**
     * 基础dp
     * @param nums
     * @return
     */
    public  int getLargestSum(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(nums[i],nums[i]+dp);
            max = Math.max(max,dp);
        }
        return max;
    }
}
