package leetCode.DataStructures.Array;

/**
 * @author:choumei
 * @date:2020/2/3 22:14
 * @Description: 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 */
public class MaxConsecutiveOnes_485 {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes2(new int[]{1,1,0,1,1,1,0,0,0,1,1,1,1,1,1}));
    }

    /**
     * 方法一：
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes1(int[] nums){
        if(nums.length <= 0){
            return 0;
        }
        int maxCnt = 0;
        int tempCnt = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == 0){
                maxCnt = Math.max(maxCnt,tempCnt);
                tempCnt = 0;
            }else {
                tempCnt++;
            }
        }
        maxCnt = Math.max(maxCnt,tempCnt);
        return maxCnt;
    }

    /**
     * 方法二：精简
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes2(int[] nums){
        int max = 0,cur = 0;
        for(int num : nums){
            cur = num == 0 ? 0 : cur+1;
            max = Math.max(max,cur);
        }
        return max;
    }
}
