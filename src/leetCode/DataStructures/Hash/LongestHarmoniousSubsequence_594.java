package leetCode.DataStructures.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/1/8 21:34
 * @Description: 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 *
 */
public class LongestHarmoniousSubsequence_594 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println("最长和谐子序列长度："+findLHS(nums));
    }
    public static int findLHS(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            //相当于以下代码
            /*Integer temp = map.get(num);
            if(null == temp){
                map.put(num,1);
            }else{
                map.put(num,temp+1);
            }*/
        }
        int longest = 0;
        for(int key : map.keySet()){
            if(map.containsKey(key+1)){
                longest = Math.max(longest,map.get(key+1)+map.get(key));
            }
        }
        return longest;
    }
}
