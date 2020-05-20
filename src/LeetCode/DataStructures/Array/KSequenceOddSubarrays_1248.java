package LeetCode.DataStructures.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/4/21 9:34
 * @Description:  统计【优美子数组】
 * 
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 */
public class KSequenceOddSubarrays_1248 {
    @Test
    public void test(){
        System.out.println(numOfSubarrays2(new int[]{1,1,2,1,1},3));
    }

    /**
     * 求出拥有K个奇数的连续子数组
     * 求出奇数位置下标，子数组个数 = 每相隔K的两个奇数围起来的区间左右偶数数目之积
     * @param nums
     * @param k
     * @return
     */
    public int numOfSubarrays(int[] nums, int k){
        //特判
        if(null == nums || k < 1 || k > nums.length){
            return 0;
        }
        int Len = nums.length;
        //存放奇数下标
        List<Integer> oddList = new ArrayList<>();
        oddList.add(-1);    //边界设定，头边界-1
        for(int i = 0; i < Len; i++){
            if(nums[i] % 2 == 1){
                oddList.add(i);
            }
        }
        oddList.add(Len);    //尾边界len
        //奇数个数不足K
        if(oddList.size() < k+2){
            return 0;
        }
        int res = 0;
        for (int i = 1; i < oddList.size() - k; i++) {
            res += ( oddList.get(i) - oddList.get(i-1) ) *
                    ( oddList.get(i + k) - oddList.get(i + k - 1));
        }
        return res;
    }

    /**
     * 自测
     * @param nums
     * @param k
     * @return
     */
    public int numOfSubarrays2(int[] nums, int k){
        if(null == nums || nums.length == 0 || k > nums.length){
            return 0;
        }
        int len = nums.length;  
        
        int resCnt = 0;    //结果集
        List<Integer> oddList = new ArrayList<Integer>();  //奇数下标数组
        
        oddList.add(-1);   //初始化左边界

        
        for (int i = 0; i < len; i++) {
            if(nums[i] % 2 != 0){
                oddList.add(i);
            }
        }
        
        oddList.add(len);
        
        //奇数总数不足k
        if(oddList.size() < k + 2){
            return 0;
        }

        for (int i = 1; i < oddList.size() - k; i++) {
            resCnt += (oddList.get(i) - oddList.get(i - 1)) * (oddList.get(i + k) - oddList.get(i + k - 1));
        }
        return resCnt;
    }
}
