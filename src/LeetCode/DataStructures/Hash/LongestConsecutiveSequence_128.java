package LeetCode.DataStructures.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/1/8 22:38
 * @Description: 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println("最长连续序列长度为："+longestConsecutive2(nums));
    }

    /**
     * 方法一
     * @param nums
     * @return
     */
    public static int longestConsecutive1(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.putIfAbsent(num,1);
        }
        int longest = 0;
        for (int key : map.keySet()){
            int tempLongest = 0;
            int tempKey = key;
            do{
                tempLongest++;
            }while(map.containsKey(++tempKey));
            longest = Math.max(longest,tempLongest);
            if(longest >=(nums.length+1)/2) break;
        }
        return longest;
    }

    /**
     * 方法二
     * @param nums
     * @return
     */
    public static int longestConsecutive2(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.putIfAbsent(num,1);
        }
        for(int num : nums){
            forward(map,num);
        }
        return maxValue(map);
    }
    public static int forward(Map<Integer,Integer> map,int num){
        if(!map.containsKey(num)){
            return 0;
        }
        int cnt = map.get(num);
        if(cnt > 1){
            return cnt;
        }
        cnt = forward(map,num+1)+1;
        map.put(num,cnt);
        return cnt;
    }
    public static int maxValue(Map<Integer,Integer> map){
        int max = 0;
        for(int num : map.keySet()){
            max = Math.max(max,map.get(num));
        }
        return max;
    }
}
