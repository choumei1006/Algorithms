package leetCode.DataStructures.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/4/28 23:02
 * @Description: 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 *
 */
public class SingleNumbers {
    @Test
    public void test(){
        System.out.println(Arrays.toString(singleNumbers(new int[]{1,2,3,4,4,2})));
    }

    /**
     * 位运算：返回数组中仅有的两个出现一次的元素
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums){
        if(null == nums || nums.length == 0){
            return null;
        }
        int[] res = new int[2];   //结果集
        int sum = 0;

        //获取目标元素（2个）的异或结果
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }

        //获取一个异或结果的不为零的位索引
        int temp = 1;
        while((sum & temp) == 0){
            temp <<= 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & temp) == 0){
                res[0] ^= nums[i];
            }else{
                res[1] ^= nums[i];
            }
        }
        return res;
    }



    public int[] singleNumbers2(int[] nums) {
        int sum=0;
        //将数组所有元素进行异或，最后的结果一定是那两个单一数字的异或结果。看上图示例
        //用示例[4,4,6,1]最后的抑或结果就是 6和1异或的结果 7
        for (int i = 0; i <nums.length ; i++) {
            sum^=nums[i];
        }
        int first = 1;
        //通过与运算找到result第一个不为0的首位，7=>0111，也就是第一位
        while((sum&first)==0){
            first=first<<1;
        }
        //first为1，所以我们可以根据数组元素的二进制低位第一位是否为1，将数组分为2类，
        // 示例数组可以分为     低位第一位为0：[4,4,6]     低位第一位为1：[1]
        //此时再将两个数组两两异或就可以得到最终结果。
        int result[]=new int[2];
        for(int i=0;i<nums.length;i++){
            //将数组分类。
            if((nums[i]&first)==0){
                result[0]^=nums[i];
            }
            else{
                result[1]^=nums[i];
            }
        }
        return result;
    }
}
