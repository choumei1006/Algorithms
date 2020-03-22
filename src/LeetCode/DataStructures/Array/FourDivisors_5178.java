package LeetCode.DataStructures.Array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:choumei
 * @date:2020/3/22 10:59
 * @Description: 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 *
 * 如果数组中不存在满足题意的整数，则返回 0 。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 *
 * [1,2,3,4,5,6,7,8,9,10]
 */

public class FourDivisors_5178 {
    @Test
    public void test(){
        System.out.println(sumFourDivisors(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num : nums){
            Set<Integer> set = getDivisorsSet(num);
            if(set.size() == 4){
                for(int temp : set){
                    sum += temp;
                }
            }
        }
        return sum;
    }
    public Set<Integer> getDivisorsSet(int num){
        Set<Integer> set = new HashSet<>();
        int sqrt = (int)Math.sqrt(num);
        for (int i = 1; i <= sqrt; i++) {
            if(num % i == 0){
                set.add(i);
                set.add(num/i);
            }
        }
        return set;
    }
}
