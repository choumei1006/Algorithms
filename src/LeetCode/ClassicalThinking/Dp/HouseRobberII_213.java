package LeetCode.ClassicalThinking.Dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/5/29 9:02
 * @Description: 【打家劫舍 II】
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 */
public class HouseRobberII_213 {
    @Test
    public void test(){
        System.out.println(rob(new int[]{2,3,2}));
    }
    public int rob(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        return Math.max(robHelper(Arrays.copyOfRange(nums, 0, len - 1)),
                robHelper(Arrays.copyOfRange(nums, 1, len)));
    }

    /**
     * 返回已知数组中最大利益
     * @param nums
     * @return
     */
    public int robHelper(int[] nums){
        int pre = 0;   //当前元素前一个元素为止最大利益
        int curMax = 0;  //当前元素为止最获利
        int tmp;
        for(int num : nums){
            tmp = curMax;
            curMax = Math.max(num + pre, curMax);
            pre = tmp;
        }
        return curMax;
    }
}
