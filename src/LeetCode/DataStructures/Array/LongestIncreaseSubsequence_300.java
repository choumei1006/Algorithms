package LeetCode.DataStructures.Array;

/**
 * @author:choumei
 * @date:2020/3/14 22:59
 * @Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 */
public class LongestIncreaseSubsequence_300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    /**
     * 思路：动态规划
     *     遍历每一个nums元素，返回当前元素之前，比它小的元素中，
     * 最大的dp[i]+1,即为：以当前元素为尾的数组中的最长升序序列长度；
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if(null == nums){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int rstLen = 1;
        for(int i = 1; i<len ;i++){
            int tempMaxLen = 0;
            for(int j = 0; j < i ;j++){
                if(nums[j] < nums[i] ){
                    tempMaxLen = Math.max(tempMaxLen,dp[j]);
                }
            }
            dp[i] = tempMaxLen+1;
            rstLen = Math.max(rstLen,dp[i]);
        }
        return rstLen;
    }
}
