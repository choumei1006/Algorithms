package LeetCode.ClassicalThinking.Diverse2;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/5/9 9:12
 * @Description: 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */
public class MySqrt_69 {
    @Test
    public void test(){
        System.out.println(mySqrt2(4));
    }

    /**
     * 方法一：数学转换
     * @param x
     * @return
     */
    public int mySqrt1(int x){
        if(x == 0){
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (ans + 1) * (ans + 1) < x ? ans + 1 : ans;
    }

    /**
     * 方法二：二分查找
     * @param x
     * @return
     */
    public int mySqrt2(int x){
        if(x == 0){
            return 0;
        }
        int l = 0, r = x;
        int ans = -1;
        while( l < r){
            int mid = l + (r - l) / 2;
            if(mid * mid <= x){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
