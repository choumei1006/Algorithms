package leetCode.DataStructures.Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/1/8 22:38
 * @Description: 【最长连续序列】
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("最长连续序列长度为：" + longestConsecutive2(nums));
    }

    /**
     * 方法一：暴力法：
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();   //存放每个元素是否出现
        for (int num : nums) {
            map.putIfAbsent(num, 1);
        }

        //最长连续序列长度
        int longest = 0;
        //对于每一个字符，判断以它开始的最长连续序列长度
        for (int key : map.keySet()) {
            int tempLongest = 0;
            int tempKey = key;
            do {
                tempLongest++;
            } while (map.containsKey(++tempKey));

            longest = Math.max(longest, tempLongest);   //更新最长长度
            if (longest >= (nums.length + 1) / 2) break;    //当结果长度已经大于总长度一半，返回
        }
        return longest;
    }

    /**
     * 方法二：动态规划
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();   //存放<num:以它开始的连续数组长度>
        for (int num : nums) {
            map.putIfAbsent(num, 1);
        }
        for (int num : nums) {
            forward(map, num);
        }
        return maxValue(map);
    }

    /**
     * 更新map中num开头的连续序列长度
     *
     * @param map
     * @param num
     * @return
     */
    public static int forward(Map<Integer, Integer> map, int num) {
        //不存在该元素键值
        if (!map.containsKey(num)) {
            return 0;
        }

        int cnt = map.get(num);
        //已经更新
        if (cnt > 1) {
            return cnt;
        }
        //未更新：等于num+1开头的连续序列长度+1
        cnt = forward(map, num + 1) + 1;
        map.put(num, cnt);
        return cnt;
    }

    /**
     * 返回最大value值
     *
     * @param map
     * @return
     */
    public static int maxValue(Map<Integer, Integer> map) {
        int max = 0;
        for (int num : map.keySet()) {
            max = Math.max(max, map.get(num));
        }
        return max;
    }

    //-------------------------------------自测-------------------------------------------------
    @Test
    public void test(){
        System.out.println(longestConsecutive3(new int[]{100, 4, 200, 1, 3, 2}));
    }

    /**
     * 方法一：暴力法
     * @param nums
     * @return
     */
    public int longestConsecutive3(int[] nums){
        //特判
        if(null == nums || nums.length == 0){
            return 0;
        }
        int longestLen = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();    //存放<元素：是否出现>
        for(int n : nums){
            map.putIfAbsent(n, 1);
        }

        for(int n : map.keySet()){
            int tmpLongestLen = 0;
            int tmpKey = n;

            do{
                tmpLongestLen++;           //只要+1的键值元素存在，则当前n开头的最长序列长度+1
            }while(map.containsKey(++tmpKey));

            longestLen = Math.max(longestLen, tmpLongestLen);

            if(longestLen > (nums.length + 1) / 2){
                break;
            }
        }
        return longestLen;
    }

    /**
     * 方法二:动态规划
     * @param nums
     * @return
     */
    public int longestConsecutive4(int[] nums){
        //特判
        if(null == nums || nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();   //存放<n：以n开头的连续序列长度>

        for(int n : nums){
            map.putIfAbsent(n, 1);
        }

        for(int n : nums){
            updateLen(map, n);
        }

        return getMaxLen(map);
    }

    /**
     * 更新n开头的最长序列长度
     * @param map
     * @param n
     * @return
     */
    public int updateLen(Map<Integer, Integer> map, int n){
        if(!map.containsKey(n)){
            return 0;
        }
        int len = map.get(n);

        if(len > 1){
            return  map.get(n);
        }

        len = updateLen(map, n + 1);
        map.put(n, len);
        return len;
    }

    /**
     * 返回map最大value
     * @param map
     * @return
     */
    public int getMaxLen(Map<Integer, Integer> map){
        if(null == map){
            return 0;
        }
        int maxLen = 0;
        for(int n : map.keySet()){
            maxLen = Math.max(maxLen, map.get(n));   //更新
        }
        return maxLen;
    }
}
