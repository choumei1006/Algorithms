package leetCode.DataStructures.Array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/5/17 12:11
 * @Description: 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 */
public class SubArraySumEqualsK_560 {
    @Test
    public void test(){
        System.out.println(subarraySum2(new int[]{1,1,1}, 2));
    }

    /**
     * 返回和为k的子数组的个数
     * 方法一：暴力枚举
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k){
        if(null == nums || nums.length == 0){
            return -1;
        }
        int cnt = 0;  //结果次数
        for (int end = 0; end < nums.length; end++) {
            int tempSum = 0;
            for (int start = end; start >= 0 ; start--) {
                tempSum += nums[start];
                if(tempSum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 方法二：前缀和+哈希表
     * ( preSum[j] - preSum[i - 1] ) == K
     * ( preSum[j] - K ) == preSum[i - 1]
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k){
        if(null == nums || nums.length == 0){
            return -1;
        }
        int cnt = 0;
        int preSum = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(map.containsKey(preSum - k)){
                cnt += map.get(preSum - k);
            }
            map.putIfAbsent(preSum, map.getOrDefault(preSum - k, 0) + 1);
        }
        return cnt;
    }
}
