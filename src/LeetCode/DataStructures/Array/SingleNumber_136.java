package LeetCode.DataStructures.Array;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/5/14 22:26
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 */
public class SingleNumber_136 {
    @Test
    public void test(){
        System.out.println(singleNumner(new int[]{2,2,1,1,4}));
    }
    public int singleNumner(int[] nums){
        if(null == nums || nums.length == 0){
            return -1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
