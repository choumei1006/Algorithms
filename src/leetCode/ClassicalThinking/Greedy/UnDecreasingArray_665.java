package leetCode.ClassicalThinking.Greedy;

/**
 * @author:choumei
 * @date:2020/9/5 16:42
 * @Description:  【修改一个数称为非递减数组】
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 */
public class UnDecreasingArray_665 {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,2,3}));
    }

    /**
     * 思路：遍历判断每个元素，若nums[i - 1] > nums[i], 分情况讨论：
     * 若nums[i - 2] <= nums[i]:nums[i - 1] = nums[i];   //下移
     * 若nums[i - 2] > nums[i]:nums[i] = nums[i - 1];   //上移
     *
     * @param nums
     * @return
     */
    public static  boolean checkPossibility(int[] nums) {
        //特判
        if (null == nums || nums.length == 0) {
            return false;
        }

        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            //非递增
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            //递减
            cnt++;
            if(i - 2 >= 0 && nums[i - 2] > nums[i]){
                nums[i] = nums[i - 1];
            }else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
