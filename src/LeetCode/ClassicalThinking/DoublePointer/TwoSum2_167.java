package LeetCode.ClassicalThinking.DoublePointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2019/11/28 9:15
 * @Description: 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */
public class TwoSum2_167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] rst = twoSum(numbers,target);
        for (int i = 0; i < rst.length; i++) {
            System.out.println(rst[i]);
        }
    }

    /**
     * 双指针
     * CyC2018 双指针：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers,int target){
        if(null == numbers) return null;
        int len = numbers.length;
        int l = 0,r = len-1;
        while(r > l){
            int sum = numbers[l]+numbers[r];
            if(sum == target) return new int[]{l+1,r+1};
            else if(sum < target) l++;
            else if(sum > target) r--;
        }
        return null;
    }

    //自解
    public static int[] twoSum2(int[] numbers,int target){
        Map<Integer,Integer> compensateIdxMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int curNumber = numbers[i];
            if(compensateIdxMap.containsKey(curNumber)){
                return new int[]{compensateIdxMap.get(curNumber),i};
            }
            compensateIdxMap.put(target-curNumber,i);
        }
        return null;
    }
}
