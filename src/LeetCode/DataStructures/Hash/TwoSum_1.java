package LeetCode.DataStructures.Hash;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author:choumei
 * @date:2020/1/7 22:28
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,26)));
    }

    /**
     * 返回nums数组种和为target的两个元素下标数组
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            Integer tempValue = map.get(nums[i]);
            if(null != tempValue){
                return new int[]{tempValue,i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }

}
