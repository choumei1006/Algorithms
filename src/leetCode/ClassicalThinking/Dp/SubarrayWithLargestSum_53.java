package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/21 18:52
 * @Description:
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
        System.out.println(getLargestSum2(new int[]{1,2,-2,4}));
    }

    /**
     * 基础dp
     * 思路：假设 nums 数组的长度是 nn，下标从 00 到 n - 1n−1。
     * 我们用 a_iai代表 nums[i]，用 f(i)f(i) 代表以第 ii 个数结尾的「连续子数组的最大和」，
     * 那么很显然我们要求的答案就是：
     * \max_{0 \leq i \leq n - 1} \{ f(i) \}0≤i≤n−1max{f(i)}
     *
     * 因此我们只需要求出每个位置的 f(i)f(i)，然后返回 f 数组中的最大值即可。
     * 那么我们如何求 f(i)f(i) 呢？
     * 我们可以考虑 a_iai单独成为一段还是加入 f(i - 1)f(i−1) 对应的那一段，
     * 这取决于 a_iai和 f(i - 1) + a_if(i−1)+ai的大小，我们希望获得一个比较大的，
     * 于是可以写出这样的动态规划转移方程：
     *
     * f(i) = max{ f(i - 1) + a_i, a_i }
     * f(i)=max{f(i−1)+ai,ai}
     * 不难给出一个时间复杂度 O(n)O(n)、空间复杂度 O(n)O(n) 的实现，即用一个 f 数组来保存 f(i)f(i) 的值，用一个循环求出所有 f(i)f(i)。考虑到 f(i)f(i) 只和 f(i - 1)f(i−1) 相关，于是我们可以只用一个变量 pre 来维护对于当前 f(i)f(i) 的 f(i - 1)f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)O(1)，这有点类似「滚动数组」的思想。
     *
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

    /**
     * 自测
     * @param nums
     * @return
     */
    public int getLargestSum2(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        int resMax = nums[0];
        int tmpMax = nums[0];
        for (int i = 1; i < nums.length; i++) {   //注意：其实索引是1
            tmpMax = Math.max(tmpMax + nums[i], nums[i]);
            resMax = Math.max(resMax, tmpMax);
        }
        return resMax;
    }
}
