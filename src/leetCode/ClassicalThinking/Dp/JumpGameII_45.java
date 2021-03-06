package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/5/4 23:40
 * @Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 */
public class JumpGameII_45 {
    @Test
    public void test(){
        System.out.println(jump2(new int[]{2,3,1,1,4}));
    }

    /**
     * 方法一：反向查找出发位置
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（1）
     * @param nums
     * @return
     */
    public int jump1(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        int res = 0;
        int len = nums.length;
        int tempObj = len-1;
        while(tempObj > 0){
            for (int i = 0; i <= tempObj; i++) {
                if(nums[i] + i >= tempObj){
                    res ++;
                    tempObj = i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 方法二：正向查找可到达的最大位置
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     * @param nums
     * @return
     */
    public int jump2(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        int res = 0;
        int len = nums.length;
        int tempEnd = 0;
        int maxPosition = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == tempEnd){
                tempEnd = maxPosition;
                res ++;
            }
        }
        return res;
    }

}
