package LeetCode.ClassicalThinking.DoublePointer;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/21 21:08
 * @Description: 求定长平均值最大的子数组
 */
public class LargestAvgOfSubarray {
    @Test
    public void test(){
        System.out.println(FindMaxAverage(new int[]{1,2,3,4,5},3));
    }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public double FindMaxAverage(int[] nums, int k){
        if(null == nums || k > nums.length){
            return 0.0d;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int temp = sum;
        for (int i = 1; i + k - 1 < nums.length; i++) {
            temp += nums[i + k - 1] - nums[i - 1];
            if(temp > sum){
                sum = temp;
            }
        }
        return sum / k;
    }
}
