package leetCode.DataStructures.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/6/4 8:44
 * @Description: 【除自身以外的数组乘积】
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 通过次数42,404提交次数61,843
 * 在真实的面试中遇到过这道题？
 *
 */
public class ProductOfArrayExceptSelf_238 {
    @Test
    public void  test(){
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{1,2,3,4})));
    }

    /**
     * 方法一：前后缀之积
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums){
        //特判
        if(null == nums || nums.length == 0){
            return null;
        }

        int len = nums.length;
        int[] preProduct = new int[len];   //前缀之积
        int[] sufProduct = new int[len];   //后缀之积
        int[] answer = new int[len];

        //处理前缀
        preProduct[0] = 1;
        for (int i = 1; i < len; i++) {
            preProduct[i] = nums[i - 1] * preProduct[i - 1];
        }

        //处理后缀
        sufProduct[len - 1] = 1;
        for (int i = len - 2; i >= 0 ; i--) {
            sufProduct[i] = nums[i + 1] * sufProduct[i + 1];
        }

        //前后缀之积即为目标数组
        for (int i = 0; i < len; i++) {
            answer[i] = preProduct[i] * sufProduct[i];
        }
        return answer;
    }

    /**
     * 方法二：前后缀之积【改进】
     * 改进：后缀之积使用一个R变量表示，白嫖answer的空间
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums){
        //特判
        if(null == nums || nums.length == 0){
            return null;
        }

        int len = nums.length;
        int[] answer = new int[len];       //前缀之积/结果集
        int R = 1;


        //处理前缀之积数组
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        //处理后缀之积+前后缀相乘
        for (int i = len - 1; i >= 0; i--) {
            answer[i] *= R;
            R *= nums[i];
        }

        return answer;
    }



}
