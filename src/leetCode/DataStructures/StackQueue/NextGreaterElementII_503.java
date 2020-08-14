package leetCode.DataStructures.StackQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/1/5 21:29
 * @Description: 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 */
public class NextGreaterElementII_503 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    /**
     * 返回循环数组中每个元素的下一个“大哥”元素组成的数组；
     * @param nums
     * @return
     */
    public static  int[] nextGreaterElements(int[] nums){
        int len = nums.length;
        int[] nextNums = new int[len];
        Arrays.fill(nextNums,-1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len*2 ; i++) {
            int tempNum = nums[i%len];
            while(!stk.isEmpty() && nums[stk.peek()] < tempNum){
                nextNums[stk.pop()] = tempNum;
            }
            if(i<len){
                stk.push(i);
            }
        }
        return nextNums;
    }
}
