package LeetCode.DataStructures.Array;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/5/26 9:24
 * @Description:  【寻找重复数】
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 */
public class FindDuplicate_287 {
    @Test
    public void test(){
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }

    /**
     * 方法一：二分查找
     * 时间复杂度：O（nlogn）:
     * ->二分查找需要logn；
     * ->对于每个mid，需要O（n）时间查找小于等于mid的整数个数；
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums){
        //特判
        if(null == nums){
            return -1;
        }
        int len = nums.length;
        int l = 1, r = len - 1, res = -1;
        //二分
        while(l <= r){
            int mid = (l + r) >> 1;   //中间位置
            int cnt = 0;

            //查找每个<=mid 的数字个数
            for (int i = 0; i < len; i++) {
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            if(cnt <= mid){
                l = mid + 1;
            }else{
                r = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}
