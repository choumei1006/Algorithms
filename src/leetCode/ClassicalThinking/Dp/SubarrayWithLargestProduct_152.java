package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/21 20:58
 * @Description: 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 */
public class SubarrayWithLargestProduct_152 {
    @Test
    public void test(){
        System.out.println(maxProduct2(new int[]{2,3,-2,4,-2}));
    }

    /**
     * 经典DP
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        int imax = 1, imin = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //因存在负数，所以可能使最大值最小值颠倒，因此必须保存最小值，当遇到负数时交换
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }

    /**
     * 自测
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums){
        //特判
        if(null == nums || nums.length == 0){
            return 0;
        }
        int resMax = Integer.MIN_VALUE;
        int tmpMax = 1, tmpMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                int temp = tmpMax;
                tmpMax = tmpMin;
                tmpMin = temp;
            }
            tmpMax = Math.max(tmpMax * nums[i], nums[i]);
            tmpMin = Math.min(tmpMin * nums[i], nums[i]);
            resMax = Math.max(tmpMax, resMax);
        }
        return resMax;
    }
}
