package leetCode.DataStructures.Array;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/6/2 10:09
 * @Description: 【求1+...+n之和】
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 10000 : 10011100010000
 * 10111110110000010000001000
 *
 */
public class LCOF1ToN__interview_64 {
    @Test
    public void test(){
        System.out.println(sumNums1(9));
    }

    /**
     * 求1+...+n的和
     * 思路：等差数列求和 + 位运算
     * 等差数列求和公式 = n *（n + 1）/2
     * ---使用位运算 >>1消除除法
     * ---使用位运算展开的方式（计算每一位对乘数的贡献，【1，10000】最多14位）消除乘法
     * @param n
     * @return
     */
    public int sumNums1(int n){
        int res = 0;
        int A = n, B = n + 1;
        boolean flag;

        //14次位运算
        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        flag = ((B & 1) > 0) && (res += A) > 0;
        B >>= 1;   //B右移方便判断当前位是否为1
        A <<= 1;    //A左移符合二进制位运算

        return res >> 1;   //  除2
    }

    /**
     * 方法二：递归
     * 时间复杂度：O(n)O(n)。递归函数递归 nn 次，
     * 每次递归中计算时间复杂度为 O(1)O(1)，因此总时间复杂度为 O(n)O(n)。
     *
     * 空间复杂度：O(n)O(n)。递归函数的空间复杂度取决于递归调用栈的深度，
     * 这里递归函数调用栈深度为 O(n)O(n)，因此空间复杂度为 O(n)O(n)。
     *
     * @param n
     * @return
     */
    public int sumNums2(int n){
        boolean flag = n > 0 && (n += sumNums2(n - 1)) > 0;
        return n;
    }

    /**
     * 方法三：try-catch
     * @param n
     * @return
     */
    public int sumNums3(int n){
        int[] test = new int[]{0};
        try{
            return test[n];
        }catch (Exception e){
            return n + sumNums3(n - 1);
        }
    }
}
